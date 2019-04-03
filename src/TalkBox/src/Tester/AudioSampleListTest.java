package Tester;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import _main.AudioSampleList;

class AudioSampleListTest {

	
	
	@Test
	public void checkInitialsizeofAudioSampleList() {
		
		AudioSampleList sampleList = new AudioSampleList();
		assertEquals(sampleList.getSize(),0);
		
		
		
	}
	
	/*
	 * 
	 * This is a replacement for guiTesting to see if the correct amount of items are added to the AudioPanel
	 */
	@Test
	public void checkAddedItemsInAudioSampleList() {  
		
		AudioSampleList sampleList = new AudioSampleList();
		
		for(int i=0; i<=6; i++) {
		
			String test = "sound";
			sampleList.AudioSampleSizeIncrement(test);
	}
		
		assertEquals(7,sampleList.getAudioSampleSizeIncrement());
		
	}
	

	
	@Test
	public void checkNullAudioFilesExists() throws IOException {
		
		AudioSampleList audio = new AudioSampleList();
		assertNotNull(null,audio.TesterListAddAudioFile().get(0));
		
		
		
	}
	
	
	

}
