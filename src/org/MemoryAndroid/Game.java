package org.MemoryAndroid;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


import android.app.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener{
	HashMap<String, String> keys=new HashMap<String, String>();
	LinkedList<String> questions= new LinkedList<String>();
	LinkedList<String> answers= new LinkedList<String>();
	LinkedList<String> guessedCorrect= new LinkedList<String>();
	View c1, c2, c3, c4, c5, c6, c7, c8, scoreXML, winXML;
	 private  MediaPlayer music = null;
	int score;
	int win;
	int twoCardsFlipped;
	int questionIndex;
	int answerIndex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		Level level=new Level(1);
		music=MediaPlayer.create(this, R.raw.memorygame);
		music.setLooping(true);
		music.start();
		keys=level.getMap();
		questions=level.getQuestion();
		answers=level.getAnswer();
		Collections.shuffle(questions);
		Collections.shuffle(answers);
		
		
		twoCardsFlipped=0;
		questionIndex=0;
		answerIndex=-1;
		keys.get(answers.get(questionIndex));
		score=0;
		win=0;
		
		c1=findViewById(R.id.card1);c2=findViewById(R.id.card2);
		c3=findViewById(R.id.card3);c4=findViewById(R.id.card4);
		c5=findViewById(R.id.card5);c6=findViewById(R.id.card6);
		c7=findViewById(R.id.card7);c8=findViewById(R.id.card8);
		c1.setOnClickListener(this);c2.setOnClickListener(this);
		c3.setOnClickListener(this);c4.setOnClickListener(this);
		c5.setOnClickListener(this);c6.setOnClickListener(this);
		c7.setOnClickListener(this);c8.setOnClickListener(this);
		scoreXML=findViewById(R.id.score); winXML=findViewById(R.id.wins);
	}
	@Override
	/**
	 * Checks with every card if 2 cards have been flipped, if so, turns the cards back over except for the
	 * ones guessed correct. If they are guessed correct, they are placed in the list for the correct guesses.
	 */
	public void onClick(View v) {
		switch (v.getId())
		{
		case R.id.card1:
			questionIndex=0;
			if(twoCardsFlipped==2){
				
				turnCardsBack();
			}
			((TextView)c1).setText(questions.get(0)); twoCardsFlipped++; break;
		case R.id.card2: 
			questionIndex=1;
			if(twoCardsFlipped==2){
				
				turnCardsBack();
			}
			((TextView)c2).setText(questions.get(1)); twoCardsFlipped++; break;
		case R.id.card3:
			questionIndex=2;
			if(twoCardsFlipped==2){
				turnCardsBack();
			}
			((TextView)c3).setText(questions.get(2)); twoCardsFlipped++; break;
		case R.id.card4: 
			questionIndex=3;
			if(twoCardsFlipped==2){
				turnCardsBack();
			}
			((TextView)c4).setText(questions.get(3)); twoCardsFlipped++; break;
		case R.id.card5: 
			((TextView)c5).setText(answers.get(0));
			answerIndex=0;
			twoCardsFlipped++;
			if(twoCardsFlipped==2){
				if(keys.get(questions.get(questionIndex)).equals(answers.get(0))){
					guessedCorrect.add(answers.get(0));
					guessedCorrect.add(questions.get(questionIndex));
					score++;
				}
			
			}
			 break;
		case R.id.card6:
			((TextView)c6).setText(answers.get(1)); 
			answerIndex=1;
			twoCardsFlipped++;
			if(twoCardsFlipped==2){
				if(keys.get(questions.get(questionIndex)).equals(answers.get(1))){
					guessedCorrect.add(answers.get(1));
					guessedCorrect.add(questions.get(questionIndex));
					score++;
				}
			} break;
		case R.id.card7: 
			((TextView)c7).setText(answers.get(2)); 
			answerIndex=2;
			twoCardsFlipped++;
			if(twoCardsFlipped==2){
				if((keys.get(questions.get(questionIndex)).equals(answers.get(2)))){
					guessedCorrect.add(answers.get(2));
					guessedCorrect.add(questions.get(questionIndex));
					score++;
				}
				
			}
			 break;
		case R.id.card8:
			((TextView)c8).setText(answers.get(3));  
			answerIndex=3;
			twoCardsFlipped++;
			if(twoCardsFlipped==2){
				if((keys.get(questions.get(questionIndex)).equals(answers.get(3)))){
					guessedCorrect.add(answers.get(3));
					guessedCorrect.add(questions.get(questionIndex));
					score++;
				}
			}
			break;
		
		}
	}
	/**
	 * Turns cards back over unless they are in the guessed correctly list. If score is 4 then the game restarts,
	 * and the win increases by 1. The cards are also shuffled.
	 */
	public void turnCardsBack(){
			if(score==4){
				score=0;
				win++;
				((TextView)winXML).setText("Wins: "+win);
				guessedCorrect.clear();
				Collections.shuffle(questions);
				Collections.shuffle(answers);
			}
			((TextView)scoreXML).setText("Score: "+score);
			twoCardsFlipped=0;
			if(!guessedCorrect.contains(questions.get(0))){
				((TextView)c1).setText("Card");
			}if(!guessedCorrect.contains(questions.get(1))){
				((TextView)c2).setText("Card");
			}if(!guessedCorrect.contains(questions.get(2))){
				((TextView)c3).setText("Card");
			}if(!guessedCorrect.contains(questions.get(3))){
				((TextView)c4).setText("Card");
			}if(!guessedCorrect.contains(answers.get(0))){
				((TextView)c5).setText("Card");
			}if(!guessedCorrect.contains(answers.get(1))){
				((TextView)c6).setText("Card");
			}if(!guessedCorrect.contains(answers.get(2))){
				((TextView)c7).setText("Card");
			}if(!guessedCorrect.contains(answers.get(3))){
				((TextView)c8).setText("Card");
			}
	}



	@Override
	protected void onDestroy() {
		super.onDestroy();
		music.stop();
	}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		music.stop();
	}


}

