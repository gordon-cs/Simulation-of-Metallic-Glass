clear
x1 = 1;
x2 = 1.2;
mc = 1;
qc = 0.05;
dx = 0.01;
dt = 0.00005;
c = dt*mc/dx^2;

u1 = repmat(1200,1,100);
u2 = repmat(1200,1,21);
u0 = [u1, u2];
length = length(u0)
u0(length)=100;
u = u0;

figure
X = linspace(-1.2,1.2,241);

i = 1;
for y = 1:30000
    u(1) = u0(2);
    for x = 2:length-1
    r = (x-1) * dx;
    ra = r + 0.5*dx;
    rb = r - 0.5*dx;
    if r>=1
       c = dt*qc/dx^2;
    else
       c = dt*mc/dx^2;
    end
    u(x) = c/r*(ra*(u0(x+1)-u0(x))-rb*(u0(x)-u0(x-1)))+u0(x);
    end
    u(length) = u0(length);
    u0 = u;
    nu = fliplr(u);
    nu(length) = [];
    A = [nu u];
    if mod(y,50)==1
        stem(X,A);
        axis([-1.5 1.5 0 1300])
        t = y*dt;
        title(['t = ' num2str(t) 'seconds']);
        xlabel( 'distance from center (cm)');
        ylabel('temperature (Celsius)')
        F(i) = getframe;
        i=i+1;
    end
end

