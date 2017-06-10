package main;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import jdk.nashorn.internal.runtime.arrays.IntElements;

import javax.sound.midi.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static javafx.application.Application.launch;

public class Controller implements Initializable {

    @FXML
    private ImageView halfNote;

    @FXML
    private MenuItem openMenu;

    @FXML
    private MenuItem aboutMenu;

    @FXML
    private MenuItem helpMenu;

    @FXML
    private Rectangle E1;

    @FXML
    private Rectangle aSharp3;

    @FXML
    private Rectangle E2;

    @FXML
    private Rectangle aSharp4;

    @FXML
    private Rectangle aSharp1;

    @FXML
    private Rectangle E3;

    @FXML
    private Rectangle aSharp2;

    @FXML
    private Rectangle E4;

    @FXML
    private Rectangle A1;

    @FXML
    private Rectangle E5;

    @FXML
    private Rectangle A2;

    @FXML
    private Rectangle A3;

    @FXML
    private Rectangle A4;

    @FXML
    private TextArea noteIO;

    @FXML
    private Rectangle F1;

    @FXML
    private Rectangle F2;

    @FXML
    private Rectangle F3;

    @FXML
    private Rectangle F4;

    @FXML
    private Rectangle B1;

    @FXML
    private Rectangle B2;

    @FXML
    private Rectangle B3;

    @FXML
    private Rectangle B4;

    @FXML
    private ImageView eighthNote;

    @FXML
    private Rectangle fSharp1;

    @FXML
    private Rectangle G1;

    @FXML
    private Rectangle fSharp3;

    @FXML
    private Rectangle G2;

    @FXML
    private Rectangle fSharp2;

    @FXML
    private Rectangle G3;

    @FXML
    private Rectangle G4;

    @FXML
    private Rectangle C1;

    @FXML
    private Rectangle C2;

    @FXML
    private Rectangle C3;

    @FXML
    private Rectangle C4;

    @FXML
    private Rectangle C5;

    @FXML
    private ImageView wholeNote;

    @FXML
    private Rectangle fSharp4;

    @FXML
    private Rectangle cSharp1;

    @FXML
    private Rectangle cSharp2;

    @FXML
    private Pane pane;

    @FXML
    private Rectangle cSharp5;

    @FXML
    private Rectangle cSharp3;

    @FXML
    private Rectangle cSharp4;

    @FXML
    private Rectangle gSharp2;

    @FXML
    private Rectangle gSharp1;

    @FXML
    private Pane eighth;

    @FXML
    private Rectangle D1;

    @FXML
    private Button playButton;

    @FXML
    private Rectangle D2;

    @FXML
    private Rectangle D3;

    @FXML
    private AnchorPane APane;

    @FXML
    private Rectangle D4;

    @FXML
    private Rectangle D5;

    @FXML
    private ImageView quarterNote;

    @FXML
    private Rectangle dSharp1;

    @FXML
    private Rectangle dSharp2;

    @FXML
    private Rectangle dSharp3;

    @FXML
    private Rectangle dSharp4;

    @FXML
    private Rectangle dSharp5;

    @FXML
    private Rectangle gSharp4;

    @FXML
    private Rectangle gSharp3;

    @FXML
    private Button resetButton;

    private ArrayList<Integer> noteArray = new ArrayList<>();
    private ArrayList<Long> timeArray = new ArrayList<>();
    private ArrayList<Integer> volumeArray = new ArrayList<>();
    private static int noteNumber = 0;
    private static long noteTime;
    private static File songFile;
    private static boolean isKeyPressed = false;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        assert halfNote != null : "fx:id=\"halfNote\" was not injected: check the FXML file 'GUI.fxml'.";
        assert E1 != null : "fx:id=\"E1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert aSharp3 != null : "fx:id=\"aSharp3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert E2 != null : "fx:id=\"E2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert aSharp4 != null : "fx:id=\"aSharp4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert aSharp1 != null : "fx:id=\"aSharp1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert E3 != null : "fx:id=\"E3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert aSharp2 != null : "fx:id=\"aSharp2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert E4 != null : "fx:id=\"E4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert A1 != null : "fx:id=\"A1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert E5 != null : "fx:id=\"E5\" was not injected: check the FXML file 'GUI.fxml'.";
        assert A2 != null : "fx:id=\"A2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert A3 != null : "fx:id=\"A3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert A4 != null : "fx:id=\"A4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert noteIO != null : "fx:id=\"noteIO\" was not injected: check the FXML file 'GUI.fxml'.";
        assert F1 != null : "fx:id=\"F1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert F2 != null : "fx:id=\"F2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert F3 != null : "fx:id=\"F3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert F4 != null : "fx:id=\"F4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert B1 != null : "fx:id=\"B1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert B2 != null : "fx:id=\"B2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert B3 != null : "fx:id=\"B3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert B4 != null : "fx:id=\"B4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert eighthNote != null : "fx:id=\"eighthNote\" was not injected: check the FXML file 'GUI.fxml'.";
        assert fSharp1 != null : "fx:id=\"fSharp1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert G1 != null : "fx:id=\"G1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert fSharp3 != null : "fx:id=\"fSharp3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert G2 != null : "fx:id=\"G2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert fSharp2 != null : "fx:id=\"fSharp2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert G3 != null : "fx:id=\"G3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert G4 != null : "fx:id=\"G4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert C1 != null : "fx:id=\"C1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert C2 != null : "fx:id=\"C2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert C3 != null : "fx:id=\"C3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert C4 != null : "fx:id=\"C4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert C5 != null : "fx:id=\"C5\" was not injected: check the FXML file 'GUI.fxml'.";
        assert wholeNote != null : "fx:id=\"wholeNote\" was not injected: check the FXML file 'GUI.fxml'.";
        assert fSharp4 != null : "fx:id=\"fSharp4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert cSharp1 != null : "fx:id=\"cSharp1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert cSharp2 != null : "fx:id=\"cSharp2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check the FXML file 'GUI.fxml'.";
        assert cSharp5 != null : "fx:id=\"cSharp5\" was not injected: check the FXML file 'GUI.fxml'.";
        assert cSharp3 != null : "fx:id=\"cSharp3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert cSharp4 != null : "fx:id=\"cSharp4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert gSharp2 != null : "fx:id=\"gSharp2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert gSharp1 != null : "fx:id=\"gSharp1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert eighth != null : "fx:id=\"eighth\" was not injected: check the FXML file 'GUI.fxml'.";
        assert D1 != null : "fx:id=\"D1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert playButton != null : "fx:id=\"playButton\" was not injected: check the FXML file 'GUI.fxml'.";
        assert D2 != null : "fx:id=\"D2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert D3 != null : "fx:id=\"D3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert APane != null : "fx:id=\"APane\" was not injected: check the FXML file 'GUI.fxml'.";
        assert D4 != null : "fx:id=\"D4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert D5 != null : "fx:id=\"D5\" was not injected: check the FXML file 'GUI.fxml'.";
        assert quarterNote != null : "fx:id=\"quarterNote\" was not injected: check the FXML file 'GUI.fxml'.";
        assert dSharp1 != null : "fx:id=\"dSharp1\" was not injected: check the FXML file 'GUI.fxml'.";
        assert dSharp2 != null : "fx:id=\"dSharp2\" was not injected: check the FXML file 'GUI.fxml'.";
        assert dSharp3 != null : "fx:id=\"dSharp3\" was not injected: check the FXML file 'GUI.fxml'.";
        assert dSharp4 != null : "fx:id=\"dSharp4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert dSharp5 != null : "fx:id=\"dSharp5\" was not injected: check the FXML file 'GUI.fxml'.";
        assert gSharp4 != null : "fx:id=\"gSharp4\" was not injected: check the FXML file 'GUI.fxml'.";
        assert gSharp3 != null : "fx:id=\"gSharp3\" was not injected: check the FXML file 'GUI.fxml'.";

        noteArray.add(null);   //
        timeArray.add(null);   // These three lines add null values to the end of the tracking arrays, this prevents an ArrayOutOfBounds error
        volumeArray.add(null); //

        noteIO.setWrapText(true); //here
        eighthNote.setOpacity(.5);
        quarterNote.setOpacity(.5);
        halfNote.setOpacity(.5);
        wholeNote.setOpacity(.5);

        pianoKeys(C1, 5, 36, 600);
        pianoKeys(cSharp1, 5, 37, 600);
        pianoKeys(C2, 5, 48, 600);
        pianoKeys(cSharp2, 5, 49, 600);
        pianoKeys(C3, 5, 60, 600);
        pianoKeys(cSharp3, 5, 61, 600);
        pianoKeys(C4, 5, 72, 600);
        pianoKeys(cSharp4, 5, 73, 600);
        pianoKeys(C5, 5, 84, 600);
        pianoKeys(cSharp5, 5, 85, 600);

        pianoKeys(D1, 5, 38, 600);
        pianoKeys(dSharp1, 5, 39, 600);
        pianoKeys(D2, 5, 50, 600);
        pianoKeys(dSharp2, 5, 51, 600);
        pianoKeys(D3, 5, 62, 600);
        pianoKeys(dSharp3, 5, 63, 600);
        pianoKeys(D4, 5, 74, 600);
        pianoKeys(dSharp4, 5, 75, 600);
        pianoKeys(D5, 5, 86, 600);
        pianoKeys(dSharp5, 5, 87, 600);

        pianoKeys(E1, 5, 40, 600);
        pianoKeys(E2, 5, 52, 600);
        pianoKeys(E3, 5, 64, 600);
        pianoKeys(E4, 5, 76, 600);
        pianoKeys(E5, 5, 88, 600);

        pianoKeys(F1, 5, 41, 600);
        pianoKeys(fSharp1, 5, 42, 600);
        pianoKeys(F2, 5, 53, 600);
        pianoKeys(fSharp2, 5, 54, 600);
        pianoKeys(F3, 5, 65, 600);
        pianoKeys(fSharp3, 5, 66, 600);
        pianoKeys(F4, 5, 77, 600);
        pianoKeys(fSharp4, 5, 78, 600);

        pianoKeys(G1, 5, 43, 600);
        pianoKeys(gSharp1, 5, 44, 600);
        pianoKeys(G2, 5, 55, 600);
        pianoKeys(gSharp2, 5, 56, 600);
        pianoKeys(G3, 5, 67, 600);
        pianoKeys(gSharp3, 5, 68, 600);
        pianoKeys(G4, 5, 79, 600);
        pianoKeys(gSharp4, 5, 80, 600);

        pianoKeys(A1, 5, 45, 600);
        pianoKeys(aSharp1, 5, 46, 600);
        pianoKeys(A2, 5, 57, 600);
        pianoKeys(aSharp2, 5, 58, 600);
        pianoKeys(A3, 5, 69, 600);
        pianoKeys(aSharp3, 5, 70, 600);
        pianoKeys(A4, 5, 81, 600);
        pianoKeys(aSharp4, 5, 82, 600);

        pianoKeys(B1, 5, 47, 600);
        pianoKeys(B2, 5, 59, 600);
        pianoKeys(B3, 5, 71, 600);
        pianoKeys(B4, 5, 83, 600);

        Platform.runLater(new Runnable() { //Grabs keyboard focus of the main pane
            @Override
            public void run() {
                System.out.println(APane.isFocused());
                if (!APane.isFocused()) {
                    APane.requestFocus();
                    System.out.println(APane.isFocused());
                    if (APane.isFocused()) {
                        System.out.println("notePane Focus Initialized");
                    } else {
                        System.out.println("Failed to Initialize notePane Focus, Keyboard Controls disabled");

                    }
                } else {
                    System.out.println("notePane Focus already Initialized");
                }

            }
        });

        helpMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                try {
                    Parent help = FXMLLoader.load(getClass().getResource("helpWindow.fxml"));
                    stage.setTitle("Help");
                    stage.setScene(new Scene(help, 851, 520));
                    stage.show();

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            }
        });

        aboutMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                try {
                    Parent about = FXMLLoader.load(getClass().getResource("aboutWindow.fxml"));
                    stage.setTitle("About");
                    stage.setScene(new Scene(about, 200,110));
                    stage.show();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            }
        });

        openMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt"),
                        new FileChooser.ExtensionFilter("Song Files (*.msng)", "*.msng"));
                File file = fileChooser.showOpenDialog(APane.getScene().getWindow());
                if (file != null) {
                    songFile = file;
                    String fileName = songFile.getName();
                    System.out.println(fileName);
                    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
                    System.out.println(fileExtension);

                    String mSong = "msng";
                    String text = "txt";
                    if (mSong.equals(fileExtension) || text.equals(fileExtension)) {
                        System.out.println("File Selected");
                        try {
                            BufferedReader fileReader = new BufferedReader(new FileReader(songFile));

                            String fileRead = fileReader.readLine();

                            volumeArray.clear();
                            timeArray.clear();
                            noteArray.clear();
                            System.out.println(noteArray.size());

                            volumeArray.add(null);
                            timeArray.add(null);
                            noteArray.add(null);
                            System.out.println(noteArray.size());

                            while (fileRead != null) {
                                String tokenize[] = fileRead.split(";");
                                Integer tempVolume = Integer.parseInt(tokenize[0]);
                                Long tempTime = Long.parseLong(tokenize[1]);
                                Integer tempNote = Integer.parseInt(tokenize[2]);


                                volumeArray.add(noteNumber, tempVolume);
                                timeArray.add(noteNumber, tempTime);
                                noteArray.add(noteNumber, tempNote);
                                noteNumber++;
                                System.out.println(noteArray.size());

                                fileRead = fileReader.readLine();
                                System.out.println("note added");

                            }
                            fileReader.close();

                        } catch (FileNotFoundException fnfe) {
                            System.out.println("file not found");

                        } catch (IOException ioe) {
                            ioe.printStackTrace();

                        }
                        System.out.println("File Loaded");
                        System.out.println(noteArray.size());
                    } else {
                        System.out.println("Invalid file type");
                    }

                }
            }
        });

        resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                noteArray.clear();
                timeArray.clear();
                noteIO.setText("Song Reset!");
                noteNumber = 0;
            }
        });

        synchronized (this) {

            APane.setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent event) {

                    javafx.scene.input.KeyCode key = event.getCode();
                    if (key == KeyCode.DIGIT1 && !isKeyPressed) {
                        noteTime = 300;
                        eighthNote.setOpacity(1);
                        isKeyPressed = true;
                    } else if (key == KeyCode.DIGIT2 && !isKeyPressed) {
                        noteTime = 600;
                        quarterNote.setOpacity(1);
                        isKeyPressed = true;
                    } else if (key == KeyCode.DIGIT3 && !isKeyPressed) {
                        noteTime = 1200;
                        halfNote.setOpacity(1);
                        isKeyPressed = true;
                    } else if (key == KeyCode.DIGIT4 && !isKeyPressed) {
                        noteTime = 2400;
                        wholeNote.setOpacity(1);
                        isKeyPressed = true;
                    } else if (key == KeyCode.R) {
                        try {
                            Synthesizer rest = MidiSystem.getSynthesizer();
                            rest.open();
                            final MidiChannel[] mc = rest.getChannels();
                            Instrument[] instrument = rest.getDefaultSoundbank().getInstruments();
                            rest.loadInstrument(instrument[90]);
                            mc[5].noteOn(0, 0);//plays note using parameters 'midiC' 'note' and 'volume', 'midiC' should never *really* change
                            try {
                                TimeUnit.MILLISECONDS.sleep(noteTime);
                            } catch (InterruptedException e) {

                            }
                            mc[5].noteOff(0);//should shutoff note after notetime has elapsed

                            noteArray.add(noteNumber, 0);//updates arrays for playback
                            timeArray.add(noteNumber, noteTime);
                            volumeArray.add(noteNumber, 0);

                        } catch (MidiUnavailableException e) {

                        }
                    }
                }
            });
            APane.setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    noteTime = 500;
                    eighthNote.setOpacity(.5);
                    quarterNote.setOpacity(.5);
                    halfNote.setOpacity(.5);
                    wholeNote.setOpacity(.5);
                    isKeyPressed = false;
                }
            });
        }

        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                synchronized (this) {
                    playback();
                }
            }
        });


    }

    private void pianoKeys(Rectangle fxid, int midiC, int note, int volume) {
        synchronized (this) {

            fxid.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        Synthesizer synth = MidiSystem.getSynthesizer();
                        synth.open();
                        final MidiChannel[] mc = synth.getChannels();
                        Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();
                        synth.loadInstrument(instrument[90]);
                        mc[midiC].noteOn(note, volume);//plays note using parameters 'midiC' 'note' and 'volume', 'midiC' should never *really* change
                        try {
                            TimeUnit.MILLISECONDS.sleep(noteTime);
                        } catch (InterruptedException e) {

                        }
                        mc[midiC].noteOff(note);//should shutoff note after notetime has elapsed

                    } catch (MidiUnavailableException e) { //fixes stuff

                    }
                    fxid.setOnMouseReleased(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            noteIO.appendText("note was: " + note);//updates textArea for reference
                            noteIO.appendText("\n");
                            int lastNote = note;
                            noteArray.add(noteNumber, lastNote);//updates arrays for playback
                            timeArray.add(noteNumber, noteTime);
                            volumeArray.add(noteNumber, volume);
                            noteNumber++;
                        }


                    });
                }

            });
        }
    }

    private void playback() {//Accesses noteArray as well as timeArray then feeds values into midi when play button clicked

        synchronized (this) {

            Long longTime;
            int currentNote;
            int time;
            int volume;

            for (int i = noteArray.size() - 1; i > 1; i = noteArray.size() - 1) {
                currentNote = noteArray.get(0);
                longTime = timeArray.get(0);
                volume = volumeArray.get(0);

                time = longTime.intValue();

                try {
                    Synthesizer synth = MidiSystem.getSynthesizer();
                    synth.open();
                    final MidiChannel[] mc = synth.getChannels();
                    Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();
                    synth.loadInstrument(instrument[90]);
                    mc[5].noteOn(currentNote, volume); //plays note using parameters 'midiC' 'note' and 'volume'


                } catch (MidiUnavailableException e) { //catches exception from line 518

                }
                try {
                    TimeUnit.MILLISECONDS.sleep(time);

                } catch (InterruptedException e) {

                }
                noteArray.remove(0);
                timeArray.remove(0);
                volumeArray.remove(0);

            }

        }
    }

}
