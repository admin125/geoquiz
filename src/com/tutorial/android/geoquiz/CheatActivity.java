package com.tutorial.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

	public final static String EXTRA_ANSWER_IS_TRUE="com.tutorial.android.geoquiz.answer_is_true";
	public final static String EXTRA_ANSWER_SHOWN="com.tutorial.android.geoquiz.answer_shown";
	public final static String TAG="CheatActivity";
	
	
	
	private boolean mAnswerIsTrue;
	private TextView mAnswerTextView;
	private Button	mShowAnswerButton;
	
	private void setAnswerShownResult(boolean isAnswerShown) {
		Intent i = new Intent();
		i.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
		setResult(RESULT_OK,i);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		Log.d(TAG,"mAnswerIsTrue = " + mAnswerIsTrue);
		
		mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
		mShowAnswerButton = (Button)findViewById(R.id.showAnswerButton);
		
		setAnswerShownResult(false);
		
		mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mAnswerIsTrue) {
					mAnswerTextView.setText(R.string.true_button);
				}
				else {
					mAnswerTextView.setText(R.string.false_button);
				}
				setAnswerShownResult(true);
			}
		});
		
	}
}
