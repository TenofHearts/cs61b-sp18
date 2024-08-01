public class Planet
{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img)
	{
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet other)
	{
		xxPos = other.xxPos;
		yyPos = other.yyPos;
		xxVel = other.xxVel;
		yyVel = other.yyVel;
		mass = other.mass;
		imgFileName = other.imgFileName;
	}

    public static double square(double x)
    {
        return x * x;
    }

	public double calcDistance(Planet other) 
    {
        return Math.sqrt(Planet.square(xxPos - other.xxPos) + Planet.square(yyPos - other.yyPos));
    }

    static final double G = 6.67e-11;

    public double calcForceExertedBy(Planet other)
    {
        return G * mass * other.mass / Planet.square(this.calcDistance(other));
    }

    public double calcForceExertedByX(Planet other)
    {
        return this.calcForceExertedBy(other) * (other.xxPos - xxPos) / this.calcDistance(other);
    }

    public double calcForceExertedByY(Planet other)
    {
        return this.calcForceExertedBy(other) * (other.yyPos - yyPos) / this.calcDistance(other);
    }

    public double calcNetForceExertedBy(Planet[] others)
    {
        
    }
}
