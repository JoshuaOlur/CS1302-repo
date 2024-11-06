package edu.westga.cs1302.password_generator.viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PasswordGeneratorViewModel {

	private PasswordGenerator generator;

	private final BooleanProperty includesDigitProperty;

	private final BooleanProperty includesLowerCaseProperty;

	private final BooleanProperty includesUpperCaseProperty;

	private final StringProperty minimumLengthProperty;

	public PasswordGeneratorViewModel() {
		Random randomNumberGenerator = new Random();
		this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());

		this.includesDigitProperty = new SimpleBooleanProperty();

		this.includesLowerCaseProperty = new SimpleBooleanProperty();

		this.includesUpperCaseProperty = new SimpleBooleanProperty();

		this.minimumLengthProperty = new SimpleStringProperty();
	}

	public BooleanProperty includesDigitProperty() {
		return this.includesDigitProperty;
	}

	public BooleanProperty includesLowerCaseProperty() {
		return this.includesLowerCaseProperty;
	}

	public BooleanProperty includesUpperCaseProperty() {
		return this.includesUpperCaseProperty;
	}

	public StringProperty minimumLengthProperty() {
		return this.minimumLengthProperty;
	}

	public String generatePassword() {
		int minimumLength = -1;

		minimumLength = Integer.parseInt(this.minimumLengthProperty.getValue());

		this.generator.setMinimumLength(minimumLength);

		this.generator.setMustHaveAtLeastOneDigit(this.includesDigitProperty.getValue());
		this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.includesLowerCaseProperty.getValue());
		this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.includesUpperCaseProperty.getValue());

		String password = this.generator.generatePassword();

		return password;
	}
}
