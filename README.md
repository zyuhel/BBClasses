BBClasses
=========

Some helper blackberry OS 5-7 JAVA Classes


UI Classes
-----------


### LinkField
Styleble LabelField, on navigation click events initiate browser opening, supports mail to links;

usage

	import ru.irsoftware.ui.LinkField;
	/* class definitions, etc */
	LinkField linkField = new LinkField("Website","http://example.com");
  
or   

	LinkField linkField = new LinkField("Contact US", "mailto:test@example.com");
	linkField.setColor(Color.BLUE);


### PhoneField

Styleble LabelField, on navigation click events initiate phone calling of the set number;

usage

	import ru.irsoftware.ui.PhoneField;
	/* class definitions, etc */
	PhoneField phoneField = new PhoneField("+34534355");
  
or   

	PhoneField phoneField = new PhoneField("Call me", "+34534355");
	phoneField.setColor(Color.RED);
