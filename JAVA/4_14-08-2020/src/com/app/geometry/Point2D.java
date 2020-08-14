/*
Q1. Create Point class Point2D , under package com.app.geometry  : for representing a point in x-y co-ordinate system.

1.1 Create a parameterized constructor to accept x & y co-ords.

1.2 Add public String getDetails()) --to return string form point's x & y co-ords

1.3 Add isEqual method to Point2D class : boolean returning method : must ret. true if both points are having same x,y co-ords or false otherwise. 

1.4 Add a method to Point2D class -- to create and return new point having given x & y offset.
	eg : Point2D p1=new Point2D(10,20);
If user supplies offset of (5, -2) : your method should return a new point object placed at (15,18)

1.5 Add calculateDistance method to calculate distance between current point & specified point & return the distance to the caller.
	(eg double  calcDistance(Point2D p2))

Hint : Use distance formula . Use java.lang.Math class methods --sqrt, pow etc.
*/

package com.app.geometry;
public class Point2D
{
	private int x,y;

	public Point2D(int x,int y)
	{
		this.x=x;
		this.y=y;
		}
	public String getDetails()
	{
		return "Co-ordinates: x--"+x+"  y--"+y;
		}
	public boolean isEqual(Point2D anotherPoint)
	{
		return this.x==anotherPoint.x && this.y==anotherPoint.y;
		}
	public Point2D createNewPoint(int xOff,int yOff)
	{
		return new Point2D(this.x+xOff,this.y+yOff);
		}
	public double calcDistance(Point2D p2)
	{
		return Math.sqrt(Math.pow(this.x-p2.x,2)+Math.pow(this.y-p2.y,2));
		}	
	}