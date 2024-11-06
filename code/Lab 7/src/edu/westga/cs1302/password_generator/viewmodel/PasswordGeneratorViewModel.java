package edu.westga.cs1302.password_generator.viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * ViewModel for generating a password with specified criteria. Binds user input
 * properties to the password generator model.
 * 
 * @version 2024
 * @author JO
 */
public class PasswordGeneratorViewModel {

	private PasswordGenerator generator;
	private final BooleanProperty includesDigitProperty;
	private final BooleanProperty includesLowerCaseProperty;
	private final BooleanProperty includesUpperCaseProperty;
	private final StringProperty minimumLengthProperty;

	/**
	 * Initializes a new PasswordGeneratorViewModel. Sets up properties and
	 * initializes the password generator.
	 */
	public PasswordGeneratorViewModel() {
		Random randomNumberGenerator = new Random();
		this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());

		this.includesDigitProperty = new SimpleBooleanProperty();
		this.includesLowerCaseProperty = new SimpleBooleanProperty();
		this.includesUpperCaseProperty = new SimpleBooleanProperty();
		this.minimumLengthProperty = new SimpleStringProperty();
	}

	/**
	 * Gets the property for including digits.
	 * 
	 * @return the includesDigitProperty
	 */
	public BooleanProperty includesDigitProperty() {
		return this.includesDigitProperty;
	}

	/**
	 * Gets the property for including lowercase letters.
	 * 
	 * @return the includesLowerCaseProperty
	 */
	public BooleanProperty includesLowerCaseProperty() {
		return this.includesLowerCaseProperty;
	}

	/**
	 * Gets the property for including uppercase letters.
	 * 
	 * @return the includesUpperCaseProperty
	 */
	public BooleanProperty includesUpperCaseProperty() {
		return this.includesUpperCaseProperty;
	}

	/**
	 * Gets the property for minimum password length.
	 * 
	 * @return the minimumLengthProperty
	 */
	public StringProperty minimumLengthProperty() {
		return this.minimumLengthProperty;
	}

	/**
	 * Generates a password based on the current settings.
	 * 
	 * @return the generated password
	 */
	public String generatePassword() {
		int minimumLength = Integer.parseInt(this.minimumLengthProperty.getValue());

		this.generator.setMinimumLength(minimumLength);
		this.generator.setMustHaveAtLeastOneDigit(this.includesDigitProperty.getValue());
		this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.includesLowerCaseProperty.getValue());
		this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.includesUpperCaseProperty.getValue());

		return this.generator.generatePassword();
	}
}
