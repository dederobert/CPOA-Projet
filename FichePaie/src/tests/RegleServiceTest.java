package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.modele.services.RegleServices;

public class RegleServiceTest {

	@Test
	public void testActionIsValideBadCotisation() {
		assertFalse(RegleServices.actionIsValide("truc = 0.08"));
	}
	
	@Test
	public void testActionIsValideBadConnector() {
		assertFalse(RegleServices.conditionIsValide("secu < 0.08"));
	}
	
	@Test
	public void testActionIsValideMuchArguments() {
		assertFalse(RegleServices.actionIsValide("secu = 0.08 pourcent"));
	}
	
	@Test
	public void testActionIsValideNotNumeric() {
		assertFalse(RegleServices.actionIsValide("secu = huit"));
	}
	
	@Test
	public void testActionIsValideActionValide() {
		assertTrue(RegleServices.actionIsValide("secu = 0.08"));
	}
	
	@Test
	public void testConditionIsValideBadVariable() {
		try{
		assertFalse(RegleServices.conditionIsValide("truc = \"cadre\""));
		}catch(IllegalArgumentException e)
		{
			
		}
	}
	
	@Test
	public void testConditionIsValideBadConnector() {
		assertFalse(RegleServices.conditionIsValide("brut * 2500"));
	}
	
	@Test
	public void testConditionIsValideMuchArgument() {
		assertFalse(RegleServices.conditionIsValide("brut = 2500 horaire"));
	}
	
	@Test
	public void testConditionIsValideConditionValide() {
		assertTrue(RegleServices.conditionIsValide("brut = 2500 ET statut = \"cadre\""));
	}
	
}
