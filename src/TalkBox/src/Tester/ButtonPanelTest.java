package Tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import _main.ButtonPanel;

class ButtonPanelTest {



	@Test
	//This is needed when the user clicks the profile and it resets column=0 so it can reset on buttonpanel first row 
	void checkifColumnReset() {
		
		ButtonPanel buttonpanel = new ButtonPanel();
		assertEquals(buttonpanel.getColumn(),0);
		
	}
	
	//This is needed when the user clicks the profile and it resets row=0 so it can reset on buttonpanel first row 
	@Test
	void checkifRoweset() {
		
		ButtonPanel buttonpanel = new ButtonPanel();
		assertEquals(buttonpanel.getRow(),0);
	}
	
	@Test
	void initialAudioButtonCountOnPanel() {
		
		ButtonPanel buttonpanel = new ButtonPanel();
		assertEquals(buttonpanel.getNumofAudioButtons(),0);
		
		
	}
 	
	
	
}
