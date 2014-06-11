package jp.ac.st.asijuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MaintenanceActivity extends Activity implements OnClickListener{

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
		backBtn.setOnClickListener(this);
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


}
