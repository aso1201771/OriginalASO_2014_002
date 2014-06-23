package jp.ac.st.asijuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MaintenanceActivity extends Activity implements OnClickListener, AdapterView.OnItemClickListener{

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;
	int selectedID = -1;
	int lastPosition = -1;


	private void setDBValuetoList(ListView lstHitokoto){
		SQLiteCursor cursor = null;

		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try {
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			Log.e("ERROR", e.toString());
		}
		cursor = this.helper.selectHitokotoList(sdb);
		int db_layout = android.R.layout.simple_list_item_activated_1;
		String [] from = {"phrase"};
		int [] to = new int [] {android.R.id.text1};
		SimpleCursorAdapter adapter =
			new SimpleCursorAdapter(this,db_layout,cursor,from,to,0);
		lstHitokoto.setAdapter(adapter);

	}






	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintenanceactivity);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button backBtn = (Button)findViewById(R.id.backBtn);
		Button deleteBtn = (Button)findViewById(R.id.deleteBtn);
		ListView lstHitokoto = (ListView)findViewById(R.id.lstHitokoto);


		backBtn.setOnClickListener(this);
		deleteBtn.setOnClickListener(this);
		lstHitokoto.setOnItemClickListener(this);

		this.setDBValuetoList(lstHitokoto);


	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Intent intent = null;
		switch(v.getId()){
		case R.id.backBtn:
			intent = new Intent(MaintenanceActivity.this, MainActivity.class);
			startActivity(intent);
		break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO 自動生成されたメソッド・スタブ

	}


}
