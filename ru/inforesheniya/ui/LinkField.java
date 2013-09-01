package ru.inforesheniya.ui;

import net.rim.blackberry.api.browser.Browser;
import net.rim.blackberry.api.browser.BrowserSession;
import net.rim.blackberry.api.invoke.Invoke;
import net.rim.blackberry.api.invoke.MessageArguments;
import net.rim.blackberry.api.mail.Address;
import net.rim.blackberry.api.mail.AddressException;
import net.rim.blackberry.api.mail.Message;
import net.rim.blackberry.api.mail.MessagingException;
import net.rim.device.api.i18n.ResourceBundleFamily;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.LabelField;

public class LinkField extends LabelField {

	private String url;
	private int color=Color.ORANGE;
	public LinkField() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LinkField(Object text) {
		super(text);

	}
    protected void paint(Graphics graphics) {
        graphics.setColor(this.color);
        
        super.paint(graphics);
    }
    public void setColor(int RGB)
    {
    	this.color=RGB;
    }
	public LinkField(Object text, long style) {
		super(text, style);
		// TODO Auto-generated constructor stub
	}

	public LinkField(Object text, long style,String param_url) {
		super(text, style);
		this.setUrl(param_url);
		// TODO Auto-generated constructor stub
	}
	
	public boolean navigationClick (int status , int time){
		if (this.getUrl().startsWith("mailto"))
		{
			Message m = new Message();
			Address a;
			try {
				a = new Address(this.getText(), this.getText());
				Address[] addresses = { a };
				m.addRecipients(
						net.rim.blackberry.api.mail.Message.RecipientType.TO,
						addresses);
				Invoke.invokeApplication(Invoke.APP_TYPE_MESSAGES,
						new MessageArguments(m));

			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else
		{
          BrowserSession bSession = Browser.getDefaultSession();                 
          bSession.displayPage(this.getUrl());
		} 
          return true;
         
     }
	
	public LinkField(ResourceBundleFamily rb, int key) {
		super(rb, key);
		// TODO Auto-generated constructor stub
	}

	public LinkField(Object text, int offset, int length, long style) {
		super(text, offset, length, style);
		// TODO Auto-generated constructor stub
	}

}
