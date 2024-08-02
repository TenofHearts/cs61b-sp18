class NBody {
    public static double readRadius(String path) {
        In in = new In(path);

        in.readInt();
        return in.readDouble();
    }

    public static void drawBackGround() {
        StdDraw.picture(0, 0, "./images/starfield.jpg");
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);

        int num = in.readInt();
        in.readDouble();

        Planet[] planets = new Planet[num];
        for (int i = 0; i < num; i++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readString());
        }

        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String path = args[2];

        double radius = NBody.readRadius(path);
        Planet[] planets = NBody.readPlanets(path);
        int num = planets.length;

        In in = new In(path);

        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        NBody.drawBackGround();
        for (Planet p : planets) {
            p.draw();
        }

        double time = 0;
        while (time <= T) {
            time += dt;
            double[] xxForces = new double[num];
            double[] yyForces = new double[num];

            for (int i = 0; i < num; i++) {
                xxForces[i] = planets[i].calcNetForceExertedByX(planets);
                yyForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            NBody.drawBackGround();
            for (int i = 0; i < num; i++) {
                planets[i].update(dt, xxForces[i], yyForces[i]);
                planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

}
