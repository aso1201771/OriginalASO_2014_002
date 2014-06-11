package jp.ac.st.asijuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button mainteBtn = (Button)findViewById(R.id.mainteBtn);
		mainteBtn.setOnClickListener(this);
		Button entryBtn = (Button)findViewById(R.id.entryBtn);
		entryBtn.setOnClickListener(this);
		Button hitokotoBtn = (Button)findViewById(R.id.hitokotoBtn);
		hitokotoBtn.setOnClickListener(this);

		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try {
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			return;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Intent intent = null;
		switch(v.getId()){
		case R.id.entryBtn:
			EditText etv = (EditText)findViewById(R.id.edtMsg);
			String inputMsg = etv.getText().toString();
			
			if(inputMsg!=null && !inputMsg.isEmpty()){
				helper.insertHitokoto(sdb, inputMsg);
			}
			
			etv.setText("");
			break;
		case R.id.mainteBtn:
			intent = new Intent(MainActivity.this, MaintenanceActivity.class);
			startActivity(intent);
		break;
		case R.id.hitokotoBtn:
			String strHitokoto = helper.selectRandomHitokoto(sdb);
			intent = new Intent(MainActivity.this, HitokotoActivity.class);
			intent.putExtra("hitokoto", strHitokoto);
			startActivity(intent);
		break;
		}

	}

}
