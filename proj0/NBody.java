class NBody {
    public static double readRadius(String path) {
        In in = new In(path);

        in.readInt();
        return in.readDouble();
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
    }
}
