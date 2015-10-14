package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.modele.services.RegleServices;

public class RegleServiceTest {

	@Test
	public void testActionIsValideBadCotisation() {
		try{
		assertFalse(RegleServices.actionIsValide("truc = 0.08"));
		}catch(IllegalArgumentException e)
		{}
	}
	
	@Test
	public void testActionIsValideBadConnector() {
		try{
		assertFalse(RegleServices.conditionIsValide("secu < 0.08"));
		}catch(IllegalArgumentException e)
		{}
	}
	
	@Test
	public void testActionIsValideMuchArguments() {
		try{
		assertFalse(RegleServices.actionIsValide("secu = 0.08 pourcent"));
		}catch(IllegalArgumentException e)
		{}
	}
	
	@Test
	public void testActionIsValideNotNumeric() {
		try{
		assertFalse(RegleServices.actionIsValide("secu = huit"));
		}catch(IllegalArgumentException e)
		{}
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
		{}
	}
	
	@Test
	public void testConditionIsValideBadConnector() {
		try{
		assertFalse(RegleServices.conditionIsValide("brut * 2500"));
		}catch(IllegalArgumentException e)
		{}
	}
	
	@Test
	public void testConditionIsValideMuchArgument() {
		try{
		assertFalse(RegleServices.conditionIsValide("brut = 2500 horaire"));
		}catch(IllegalArgumentException e)
		{}
	}
	
	@Test
	public void testConditionIsValideConditionValide() {
		assertTrue(RegleServices.conditionIsValide("brut = 2500 ET statut = \"cadre\""));
	}
	
}
