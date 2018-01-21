import java.awt.*;
import javax.swing*;
import java.io.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;

public class BeatBoxFinal {

	JFrame theFrame;
	JPanel mainPanel;
	JList incomingList;
	JTextField userMessage;
	ArrayList<JCheckBox> checkboxList;
	int nextNum;
	Vector<String> listVector = new Vector<String, boolean[]>();
	String userName;
	ObjectOutputStream out;
	ObjectInputStream in;
	HashMap<String, boolean[]> otherSeqsMap = new HashMap<String, boolean[]>();
	
	Sequencer sequencer;
	Sequence sequence;
	Sequence mySequence = null;
	Track track;
	
	
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
	
	int[]
	
