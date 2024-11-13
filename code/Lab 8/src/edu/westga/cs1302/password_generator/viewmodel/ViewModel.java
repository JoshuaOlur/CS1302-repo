package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;
import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**
 * Manages utilizing the model and makes properties available to bind the UI
 * elements.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class ViewModel {
	private StringProperty minimumLength;
	private BooleanProperty requireDigits;
	private BooleanProperty requireLowercase;
	private BooleanProperty requireUppercase;
	private ListProperty<String> passwords;
	
	private ArrayList<String> passwordsList;

	private PasswordGenerator generator;

	/**
	 * Initialize the properties for the viewmodel
	 */
	public ViewModel() {
		this.minimumLength = new SimpleStringProperty("1");
		this.requireDigits = new SimpleBooleanProperty(false);
		this.requireLowercase = new SimpleBooleanProperty(false);
		this.requireUppercase = new SimpleBooleanProperty(false);
		this.passwordsList = new ArrayList<>();

		Random randomNumberGenerator = new Random();
		this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
		this.passwords = new SimpleListProperty<String>(FXCollections.observableArrayList(this.passwordsList));
	}

	/**
	 * Return the minimum length property
	 * 
	 * @return the minimum length property
	 */
	public StringProperty getMinimumLength() {
		return this.minimumLength;
	}

	/**
	 * Return the require digits property
	 * 
	 * @return the require digits property
	 */
	public BooleanProperty getRequireDigits() {
		return this.requireDigits;
	}

	/**
	 * Return the require upper case property
	 * 
	 * @return the require upper case property
	 */
	public BooleanProperty getRequireUppercase() {
		return this.requireUppercase;
	}

	/**
	 * Return the require lower case property
	 * 
	 * @return the require lower case property
	 */
	public BooleanProperty getRequireLowercase() {
		return this.requireLowercase;
	}
	
	/**
	 * Return the passwords property
	 * 
	 * @return the passwords property
	 */
	public ListProperty<String> getPasswords() {
		return this.passwords;
	}

	/**
	 * Generates a password using the minimum length, require digit, require lower
	 * case, and require upper case property values.
	 * 
	 * If a password is successfully generated, the error text property is set to
	 * empty string and the password property is set to the password generated.
	 * 
	 * If an error is encountered, the password property is set to empty, and the
	 * error text property is populated with a message describing the problem.
	 */
	public void generatePassword() {
		int minimumLength = -1;

		try {
			minimumLength = Integer.parseInt(this.minimumLength.getValue());
		} catch (NumberFormatException numberError) {
			return;
		}

		try {
			this.generator.setMinimumLength(minimumLength);
		} catch (IllegalArgumentException invalidLengthError) {
			return;
		}

		this.generator.setMustHaveAtLeastOneDigit(this.requireDigits.getValue());
		this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.requireLowercase.getValue());
		this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.requireUppercase.getValue());

		String password = this.generator.generatePassword();

		this.passwordsList.add(password);
		this.passwords.setValue(FXCollections.observableArrayList(this.passwordsList));
	}

}
