% this is the matlab version of the simulation
% all lengths are in millimeters
clear

% ----------- constants
radius = 7;            % radius of the tube
quth = 1;              % thickness of the tube
h = 50;                % height of the tube
dr = 0.1;
dz = 0.1;
dt = 0.0025;           %time step dr^2 >= 4*dt
m = h/dz + 1;
n = radius/dr + 1;
r = radius/dr;
mc = 1;
qc = 0.05;

% ----------- initialize temperature at every point
u0 = repmat(1200,m,n);
[m,n] = size(u0);
u0(:,n) = 100;
for i = m-r:m
    x = i-(m-r);
    for j = 1:n
        y = j-1;
        if x^2+y^2>r^2
            u0(i,j)=100;
        end
    end
end
u = u0;

% ----------- main function, starting calculation
for j = 1:30000         % total time steps
  u(1,:) = u0(2,:);     % the middle col is always equal to the col next to it.
  u(:,1) = u0(:,2);     % the first row is always equal to the second row.
  for y = 2:m-1
    for x = 2:n-1
      ri = (x-1) * dr;
      if  ((y-(m-r))>=0 && ((x*dr)^2+((y-(m-r))*dz)^2>=(radius-quth)^2))...
            ||ri>=(radius-quth)
        c = qc;
      else
        c = mc;
      end
      u(y,x) = u0(y,x) + c*dt*(1/ri*((u0(y,x+1)-u0(y,x-1))/dr) ...
               +((u0(y,x+1)-2*u0(y,x)+u0(y,x-1))/dr^2) ...
               +((u0(y+1,x)-2*u0(y,x)+u0(y-1,x))/dz^2));
    end
  end

  for a = m-r:m
    x = a-(m-r);
    for b = 1:n
      y = b-1;
        if x^2+y^2>=r^2
          u(a,b)=100;
        end
    end
  end

  u0 = u;
  nu = fliplr(u);
  nu(:,n) = [];
  A = [nu u];

  % label the graph
  if mod(j,50)==1
    t = j*dt;
    colormap('jet');
    imagesc(A);
    colorbar;
    caxis([100, 1200]);
    axis equal tight
    title(['t = ' num2str(t) 'seconds']);
    xlabel( 'distance from center (mm/10)');
    ylabel('depth from top of the tube (mm/10)');
    F = getframe;
  end
end
