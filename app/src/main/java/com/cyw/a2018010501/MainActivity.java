package com.cyw.a2018010501;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5,bt6;
    TextView tv1,tv2,tv3,tv4;
    int ch=-1;
    int temp=-1;
    boolean[] chks=new boolean[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        bt5 = (Button) findViewById(R.id.button5);
        bt6 = (Button) findViewById(R.id.button6);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            //按了一個鈕跳出Dialog, 可按確定取消及help,按旁邊Dialog就會消失
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("This is title");
                builder.setMessage("Hello");
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你按了確定", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你按了取消", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNeutralButton("Help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你按了Help", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//按了一個鈕跳出Dialog, 可按確定取消及help,按旁邊Dialog就會消失
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("This is title");
                final EditText et = new EditText(MainActivity.this);
                //先把textview的值放到editview
                et.setText(tv1.getText().toString());
                builder.setView(et);
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //把打的資料放進去textview
                        tv1.setText(et.getText().toString());

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你按了取消", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNeutralButton("Help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你按了Help", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();


            }

        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("水果列表");
                final String[] fruits = {"蘋果", "香蕉", "鳳梨"};
                builder.setItems(fruits, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv2.setText(fruits[i]);
                    }
                });

                builder.setCancelable(false);//沒選東西按旁邊不能取消畫面,此時要加取消鈕
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //不用寫東西
                    }
                });
                builder.show();

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("水果列表");
                //ch與temp用來控制取消時Dialog item被選擇的項目,例如選apple,案確定, textview呈現apple,這時再打開按鳳梨但取消, 再打開時dialog還是出現鳳梨
                final String[] fruits = {"蘋果", "香蕉", "鳳梨"};
                temp = ch;
                builder.setSingleChoiceItems(fruits, ch, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //一選的時候就記起來
                        temp = i;
                    }
                });
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //按確定再給ch
                        if (ch == -1) {
                        }
                        {
                            ch = temp;
                            tv3.setText(fruits[ch]);
                            //ch=-1;
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, String.valueOf(temp), Toast.LENGTH_SHORT).show();
                        //ch=-1;
                    }
                });
                builder.show();
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("多選列表");
                final String[] fruits = {"蘋果", "香蕉", "鳳梨"};
                builder.setMultiChoiceItems(fruits, chks, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    }
                });
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < 5; j++) {
                          if (chks[j]) {
                                sb.append(fruits[j] + ",");
                            }
                        }
                        tv4.setText(sb.toString());
                    }

                });

                builder.setCancelable(false);//沒選東西按旁邊不能取消畫面,此時要加取消鈕
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //不用寫東西
                    }
                });
                builder.show();

            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("自訂表單抬頭");
                LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
                View v1=inflater.inflate(R.layout.layout1,null);
                final TextView tv=v1.findViewById(R.id.textView5);
                Button btn1 = v1.findViewById(R.id.button7);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv.setText("Hello World");
                    }
                });
                builder.setView(v1);
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Toast.makeText(MainActivity.this, "按下了確定", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

}
}
