package Tester;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import _main.Serializer;
import _main.TalkBoxConfig;

/*
 * To test the serialization, a specific configuration was used:
 * 
 * 5 Audio Buttons
 * 3 Profiles -> {Profile 1, Profile 2, Profile 3}
 * 8 Audio Files
 * Profile 1 Audio Files -> {Hello, Boring}
 * Profile 2 Audio Files -> {Clap}
 * Profile 3 Audio Files -> {Bye,Laugh,Bye,Laugh,Bye}
 * Audio Path -> src/Audio/
 * 
 * 
 */

class TestSerialization {

	TalkBoxConfig tbc = new TalkBoxConfig();
	
	@BeforeEach
	void setup() throws Exception {
		tbc = (TalkBoxConfig) Serializer.Load("TalkBox/TalkBoxData/TalkBoxData.tbc"); 
	}

	//Test if path to audio files is correct
	@Test
	void PathtoAudio() {
		assertEquals("TalkBox/Audio",tbc.path);
	}
	
	//Test if serialized correct number of profiles
	@Test
	void NumofProfiles() {
		assertEquals(3,tbc.Profiles.size());
	}
	
	//Test if serialized correct number of profiles
	@Test
	void NumofProfiles2() {
		Assert.assertNotSame(2,tbc.Profiles.size());
	}
	
	//Test if serialized correct number of total Audio files
	@Test
	void NumofAudioFiles() {
		assertEquals(9,tbc.NumOfAudioSets);
	}
	
	//Test if serialized correct number of total Audio files
	void NumofAudioFiles2() {
		assertEquals(3,tbc.NumOfAudioSets);
	}
	
	@Test
	void RenameCorrectly() {
		assertEquals("Rename",tbc.rename.get(0).get(0));
	}
	
	//Test if serialized correct Audio array
	@Test
	void audioArray() {
		System.out.println(Arrays.deepToString(tbc.getAudioFileNames()));
		String [][] temp = new String[][]
				{{"boring","Ah e","Good Bye",null},
			     {"Nani","Laugh","Bye","Help"},
			     {"Laugh","Yes",null,null}};
		Assert.assertArrayEquals(temp,tbc.getAudioFileNames());
	}
	
	
}