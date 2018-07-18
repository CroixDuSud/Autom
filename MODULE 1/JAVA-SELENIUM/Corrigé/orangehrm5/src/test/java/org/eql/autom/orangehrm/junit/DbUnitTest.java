package org.eql.autom.orangehrm.junit;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DbUnitTest {

	private String driver = "org.postgresql.Driver";
	private String connexionstring = "jdbc:postgresql://localhost:5432/jpetstore";
	private String login = "postgres";
	private String password = "admin";

	public IDataSet lireFichierXMLDansUnDataset(String cheminSurLeDisque) throws MalformedURLException, DataSetException {
		return new FlatXmlDataSetBuilder().build(new File(cheminSurLeDisque));
	}
	
	@Before
	public void insertionDeDonnees() throws Exception {
		
		//source de données (XML DBunit)
		IDataSet insertion = this.lireFichierXMLDansUnDataset("src/test/resources/InsertionDataset.xml");
		
		//Connexion à la base de données
		IDatabaseTester tester = new JdbcDatabaseTester(driver, connexionstring, login, password);
		tester.setSetUpOperation(DatabaseOperation.INSERT);
		tester.setDataSet(insertion);
		
		//Appel pour insérer
		tester.onSetup();
		
		//Fermeture de la connexion à la base de données
		tester.getConnection().close();
	}
	
	@After
	public void suppressionDeDonnees() throws Exception {
		
		//source de données qui décrit ce qu'il y a à supprimer (XML DBUnit)
		IDataSet suppression = this.lireFichierXMLDansUnDataset("src/test/resources/InsertionDataset.xml");
		
		//Connexion à la base de données
		IDatabaseTester tester = new JdbcDatabaseTester(driver, connexionstring, login, password);
		tester.setTearDownOperation(DatabaseOperation.DELETE);
		tester.setDataSet(suppression);
				
		//Appel pour supprimer
		tester.onTearDown();
		
		//Fermeture de la connexion à la base de données
		tester.getConnection().close();
	}

	@Test
	public void verificationDeLInsertion() throws SQLException, Exception {
		
		//source de données qui décrit l'attendu (XML DBunit)
		IDataSet suppression = this.lireFichierXMLDansUnDataset("src/test/resources/expected.xml");
		ITable tableAttendue = suppression.getTable("category");
		
		//Connexion à la base de données
		IDatabaseTester tester = new JdbcDatabaseTester(driver, connexionstring, login, password);
		IDataSet dataset = tester.getConnection().createDataSet();
		ITable tableEffective = dataset.getTable("category");
		
		//Appel pour comparer l'attendu à la base de données
		String[] tab = new String[1];
		tab[0] = "descn";
		Assertion.assertEqualsIgnoreCols(tableAttendue, tableEffective, tab);
	}
	
	@Test
	public void verificationDeLInsertion2() throws SQLException, Exception {
		
		//source de données qui décrit l'attendu (XML DBunit)
		IDataSet suppression = this.lireFichierXMLDansUnDataset("src/test/resources/InsertionDataset.xml");
		ITable tableAttendue = suppression.getTable("category");
		
		//Connexion à la base de données
		IDatabaseTester tester = new JdbcDatabaseTester(driver, connexionstring, login, password);
		ITable tableEffective = tester.getConnection()
				.createQueryTable("category", "SELECT * FROM category WHERE catid='rabbits'");
		
		//Appel pour comparer l'attendu à la base de données
		String[] tab = new String[1];
		tab[0] = "descn";
		Assertion.assertEqualsIgnoreCols(tableAttendue, tableEffective, tab);
	}
}
