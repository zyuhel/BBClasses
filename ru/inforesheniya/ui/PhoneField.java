package ru.inforesheniya.ui;

import net.rim.blackberry.api.invoke.Invoke;
import net.rim.blackberry.api.invoke.PhoneArguments;
import net.rim.device.api.i18n.ResourceBundleFamily;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.LabelField;

public class PhoneField extends LabelField {

	private String phone;
	private int color=Color.ORANGE;
	

	/**
	 * Set element color
	 * 
	 * @param RGB
	 */
	public void setColor(int RGB)
    {
    	this.color=RGB;
    }
	public PhoneField() {
	}

	/**
	 * 
	 * @return assigned phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Assign phone number
	 * @param phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	/**
	 * Creates element where phone number and title are the same
	 * @param Phone number/Title
	 */
	public PhoneField(Object text) {
		super(text);
		this.setPhone(text.toString());
	}

	protected void paint(Graphics graphics) {
		graphics.setColor(this.color);
		super.paint(graphics);
	}

	public PhoneField(Object text, long style) {
		super(text, style);
		this.setPhone(text.toString());
	}

	/**
	 * Constructs a new PhoneField
	 * 
	 * @param Shown Text
	 * @param style
	 * @param Phone Number
	 */
	public PhoneField(Object text, long style, String phone_number) {
		super(text, style);
		this.setPhone(phone_number);
	}

	/**
	 * Constructs a new PhoneField
	 * 
	 * @param Shown Text
	 * @param Phone Number
	 * @param style
	 */
	public PhoneField(Object text, String phone_number, long style) {
		super(text, style);
		this.setPhone(phone_number);
	}

	public boolean navigationClick(int status, int time) {
		Invoke.invokeApplication(Invoke.APP_TYPE_PHONE, new PhoneArguments(
				PhoneArguments.ARG_CALL, this.getPhone()));
		return true;

	}

	public PhoneField(ResourceBundleFamily rb, int key) {
		super(rb, key);
	}

	public PhoneField(Object text, int offset, int length, long style) {
		super(text, offset, length, style);
	}

}
