package pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class PhoneDialerActivity extends Activity {
	
	public static int btnIds[] = {
		R.id.button0,
		R.id.button1,
		R.id.button2,
		R.id.button3,
		R.id.button4,
		R.id.button5,
		R.id.button6,
		R.id.button7,
		R.id.button8,
		R.id.button9,
		R.id.buttonStar,
		R.id.buttonHashTag,	
	};
	
	public class digitsClick implements OnClickListener {
    	
    	@Override
    	public void onClick(View v) {
    		EditText t = (EditText) findViewById(R.id.editText1);
    		Button btn = (Button) findViewById(v.getId());
    		
    		t.setText(t.getText() + "" + btn.getText());
    		t.setSelection(t.getText().toString().length());
    	}
    }
	
	public class callClick implements OnClickListener {
    	
    	@Override
    	public void onClick(View v) {
    		EditText t = (EditText) findViewById(R.id.editText1);
    		
    		Intent intent = new Intent(Intent.ACTION_CALL);
    		intent.setData(Uri.parse("tel:" + t.getText().toString()));
    		startActivity(intent);
    	}
    }
	
	public class cancelClick implements OnClickListener {
    	
    	@Override
    	public void onClick(View v) {
    	}
    }
	
	public class backClick implements OnClickListener {
    	
    	@Override
    	public void onClick(View v) {
    		EditText t = (EditText) findViewById(R.id.editText1);
    		String text = t.getText().toString();
    		
    		t.setText(text.substring(0, text.length()-1));
    	}
    }
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        
        digitsClick digitListener = new digitsClick();
        
        for (int i = 0; i < 12; i++) {
        	Button b = (Button) findViewById(btnIds[i]);
        	b.setOnClickListener(digitListener);
        }
        
        Button b = (Button) findViewById(R.id.buttonCall);
        b.setOnClickListener(new callClick());
        
        b = (Button) findViewById(R.id.buttonBack);
        b.setOnClickListener(new backClick());
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
