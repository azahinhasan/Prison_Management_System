package interfaces;

import java.lang.*;
import entity.*;

public interface IPrisonerRepo
{
	public void insertPrisoner(Prisoner p);
	public String[][] getAllPrisoner();
	public void insertReleased_prisoner(Prisoner p);
	public String[][] getAllReleased_prisoner();
	public Prisoner searchPrisoner(String PrisonerId);
	
}