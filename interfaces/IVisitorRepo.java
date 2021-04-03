package interfaces;

import java.lang.*;
import entity.*;

public interface IVisitorRepo
{
	void insertVisitor(Visitor u);
	String[][] getAllVisitor();
}