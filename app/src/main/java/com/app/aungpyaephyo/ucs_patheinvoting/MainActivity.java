package com.app.aungpyaephyo.ucs_patheinvoting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref= null;

    private Button boys,girls,login;
    //qr code scanner object
    private IntentIntegrator qrScan;
    List<String> cst1= Arrays.asList("1A-1 c5459b", "1A-2 cd9d2c", "1A-3 5040f3", "1A-4 e8d32c", "1A-5 7cb5d5", "1A-6 9d00dc", "1A-7 f48543", "1A-8 fe7f6d", "1A-9 5b5626", "1A-10 484720", "1A-11 2d08ca", "1A-12 be3310", "1A-13 caf039", "1A-14 fc4256", "1A-15 9abff3", "1A-16 d484af", "1A-17 4c6cfb", "1A-18 6c4823", "1A-19 0e5cc4", "1A-20 c03e84", "1A-21 091e79", "1A-22 ebbeb9", "1A-23 e3d4cd", "1A-24 81fa5f", "1A-25 d57cec", "1A-26 f53277", "1A-27 daa4f0", "1A-28 34fd89", "1A-29 d4e11b", "1A-30 e8403f", "1A-31 9187f5", "1A-32 d60201", "1A-33 11026e", "1A-34 3c79bd", "1A-35 073218", "1A-36 266822", "1A-37 1adf5d", "1A-38 2187aa", "1A-39 ef9f3c", "1A-40 8966e0", "1A-41 5a7efc", "1A-42 4b62a6", "1A-43 e7e68b", "1A-44 a500c6", "1A-45 feb68f", "1A-46 35c10f", "1A-47 4c23d7", "1A-48 0ab6b6", "1A-49 dd29c0", "1A-50 e8c70a","1B-1 f0f59b", "1B-2 0ea42c", "1B-3 2ab1f3", "1B-4 b7e52c", "1B-5 fbedd5", "1B-6 66c1dc", "1B-7 e50143", "1B-8 5b7c6d", "1B-9 49b626", "1B-10 e48220", "1B-11 a197ca", "1B-12 071e10", "1B-13 2e5339", "1B-14 e74456", "1B-15 df18f3", "1B-16 7553af", "1B-17 779dfb", "1B-18 691123", "1B-19 6f56c4", "1B-20 8bca84", "1B-21 5aec79", "1B-22 2b5fb9", "1B-23 6221cd", "1B-24 b0a85f", "1B-25 3dddec", "1B-26 1cae77", "1B-27 713bf0", "1B-28 c0b589", "1B-29 30871b", "1B-30 3da33f", "1B-31 4240f5", "1B-32 2e2801", "1B-33 83a26e", "1B-34 2ec7bd", "1B-35 34a218", "1B-36 18b022", "1B-37 7cbe5d", "1B-38 01d3aa", "1B-39 f3d73c", "1B-40 4bb5e0", "1B-41 18acfc", "1B-42 f746a6", "1B-43 ce478b", "1B-44 6d01c6", "1B-45 88648f", "1B-46 d7250f", "1B-47 5b0fd7");

    List<String> cst2=Arrays.asList("2A-1 80399b", "2A-2 c9f22c", "2A-3 6913f3", "2A-4 fda92c", "2A-5 a815d5", "2A-6 f119dc", "2A-7 84f043", "2A-8 74126d", "2A-9 d8e826", "2A-10 5fb820", "2A-11 ff51ca", "2A-12 0e7e10", "2A-13 02d139", "2A-14 5dcb56", "2A-15 50f3f3", "2A-16 4c71af", "2A-17 d7cefb", "2A-18 11b423", "2A-19 514fc4", "2A-20 2d8084", "2A-21 c40479", "2A-22 3070b9", "2A-23 ad19cd", "2A-24 f9e25f", "2A-25 9831ec", "2A-26 702677", "2A-27 2b34f0", "2A-28 eab189", "2A-29 f73d1b", "2A-30 b6683f", "2A-31 5a47f5", "2A-32 f42001", "2A-33 073e6e", "2A-34 f8b1bd", "2A-35 aea818", "2A-36 2ec922", "2A-37 ab5f5d", "2A-38 4128aa", "2A-39 3ff33c", "2A-40 f99fe0", "2A-41 07c5fc", "2A-42 7a23a6", "2A-43 b93e8b", "2A-44 c547c6", "2A-45 0f7a8f", "2A-46 a2230f", "2A-47 eb5bd7", "2A-48 1427b6", "2A-49 e329c0", "2A-50 c0020a", "2A-51 0f7d88", "2A-52 18b5c8","2B-1 44a79b", "2B-2 08a92c", "2B-3 97c8f3", "2B-4 be1c2c", "2B-5 bb1bd5", "2B-6 72f7dc", "2B-7 8ad143", "2B-8 05fc6d", "2B-9 94ee26", "2B-10 253020", "2B-11 8d57ca", "2B-12 a04c10", "2B-13 8eb139", "2B-14 c28b56", "2B-15 31f8f3", "2B-16 5ec2af", "2B-17 809dfb", "2B-18 4dc723", "2B-19 a7aac4", "2B-20 bdb684", "2B-21 810879", "2B-22 8adfb9", "2B-23 3904cd", "2B-24 d5585f", "2B-25 f387ec", "2B-26 670877", "2B-27 4db2f0", "2B-28 2d1089", "2B-29 8d001b", "2B-30 ed4f3f", "2B-31 a673f5", "2B-32 8d2f01", "2B-33 6f876e", "2B-34 cc83bd", "2B-35 9c0418", "2B-36 e3b422", "2B-37 66e55d", "2B-38 bb3caa", "2B-39 89cf3c", "2B-40 1491e0", "2B-41 f841fc", "2B-42 c7cca6", "2B-43 55a88b", "2B-44 8c61c6", "2B-45 83098f", "2B-46 4a170f", "2B-47 c05fd7", "2B-48 a51db6", "2B-49 7af7c0", "2B-50 ddfa0a", "2B-51 9b4188", "2B-52 ba51c8");

    List<String> cst3=Arrays.asList("3CS-1 66849b", "3CS-2 b55b2c", "3CS-3 cdbcf3", "3CS-4 a3262c", "3CS-5 7514d5", "3CS-6 7002dc", "3CS-7 c97d43", "3CS-8 74496d", "3CS-9 11ae26", "3CS-10 caeb20", "3CS-11 1dcbca", "3CS-12 07d810", "3CS-13 bd3b39", "3CS-14 b79a56", "3CS-15 5145f3", "3CS-16 4daaaf", "3CS-17 f350fb", "3CS-18 713a23", "3CS-19 944bc4", "3CS-20 559a84", "3CS-21 9d5879", "3CS-22 ab3fb9", "3CS-23 d18fcd", "3CS-24 bef05f", "3CS-25 aed8ec", "3CS-26 7d0e77", "3CS-27 11adf0", "3CS-28 4a2d89", "3CS-29 c3f41b", "3CS-30 aa9d3f", "3CS-31 0b57f5", "3CS-32 dec801", "3CS-33 fda06e", "3CS-34 cfcabd", "3CS-35 62cc18", "3CS-36 4dfc22", "3CS-37 ddb65d", "3CS-38 b4d6aa", "3CS-39 58b53c", "3CS-40 232fe0", "3CS-41 1c47fc", "3CS-42 42a9a6", "3CS-43 86868b", "3CS-44 0dc4c6", "3CS-45 66ca8f", "3CS-46 22400f", "3CS-47 5836d7", "3CS-48 0cdeb6", "3CS-49 2770c0", "3CS-50 aad10a", "3CS-51 e3c888", "3CS-52 634ac8", "3CS-53 d117f0", "3CS-54 6ac536", "3CS-55 4b4111", "3CS-56 670566", "3CS-57 c32c7f", "3CS-58 bd2099", "3CS-59 d153a2", "3CS-60 b35644", "3CS-61 0baa91", "3CS-62 91c78c", "3CS-63 2431a4", "3CS-64 e0ac35", "3CS-65 0174fb", "3CS-66 629ab1", "3CS-67 b6e658","3CT-1 8d7d9b", "3CT-2 064f2c", "3CT-3 6bc3f3", "3CT-4 2e942c", "3CT-5 9c3dd5", "3CT-6 c35adc", "3CT-7 397e43", "3CT-8 3b216d", "3CT-9 a1a926", "3CT-10 6d5520", "3CT-11 c74aca", "3CT-12 326710", "3CT-13 26ca39", "3CT-14 f88b56", "3CT-15 700ef3", "3CT-16 3fcaaf");

    List<String> cst4=Arrays.asList("4CS-1 9b1b9b", "4CS-2 e8f52c", "4CS-3 d9e6f3", "4CS-4 cc242c", "4CS-5 b37dd5", "4CS-6 5d6edc", "4CS-7 cbb243", "4CS-8 fc006d", "4CS-9 861b26", "4CS-10 ce5020", "4CS-11 50a6ca", "4CS-12 19d410", "4CS-13 2a1f39", "4CS-14 868856", "4CS-15 bb96f3", "4CS-16 b56aaf", "4CS-17 3ae0fb", "4CS-18 a45823", "4CS-19 7314c4", "4CS-20 a2d484", "4CS-21 8ea679", "4CS-22 a5a2b9", "4CS-23 4fdbcd", "4CS-24 6a265f", "4CS-25 2cd6ec", "4CS-26 f15277", "4CS-27 3c1bf0", "4CS-28 a16789", "4CS-29 e5631b", "4CS-30 ddda3f", "4CS-31 af1cf5", "4CS-32 5d1b01", "4CS-33 d0856e", "4CS-34 e765bd", "4CS-35 4ce718", "4CS-36 70f722", "4CS-37 733f5d", "4CS-38 0084aa", "4CS-39 7ff33c", "4CS-40 3553e0", "4CS-41 6f2ffc", "4CS-42 1646a6", "4CS-43 54ab8b", "4CS-44 da37c6", "4CS-45 6d838f", "4CS-46 241f0f", "4CS-47 25d5d7", "4CS-48 a764b6", "4CS-49 b114c0", "4CS-50 d84c0a", "4CS-51 a70588", "4CS-52 b582c8", "4CS-53 8298f0", "4CS-54 28f536", "4CS-55 eadf11", "4CS-56 f7b966", "4CS-57 2e707f", "4CS-58 90d999", "4CS-59 546ba2", "4CS-60 0a5444", "4CS-61 b1eb91", "4CS-62 18dd8c", "4CS-63 7503a4", "4CS-64 14a235", "4CS-65 c930fb", "4CS-66 204fb1", "4CS-67 d96d58", "4CS-68 62e9db", "4CS-69 58dc46", "4CS-70 d8d415", "4CS-71 9dc914", "4CS-72 e1ab1d", "4CS-73 7823c5", "4CS-74 804f51", "4CS-75 34b4c3", "4CS-76 9496c4", "4CS-77 0d53de", "4CS-78 4dca51", "4CS-79 7500d7", "4CS-80 50538d", "4CS-81 75bd7b", "4CS-82 0d4e1c", "4CS-83 794323", "4CS-84 95a021", "4CS-85 145993", "4CS-86 f130d9", "4CS-87 42806d","4CT-1 28219b", "4CT-2 62dc2c", "4CT-3 df28f3", "4CT-4 91392c", "4CT-5 95abd5", "4CT-6 6694dc", "4CT-7 97d443");

    List<String> cst5=Arrays.asList("5CS-1 667a9b", "5CS-2 5fa92c", "5CS-3 82edf3", "5CS-4 08c62c", "5CS-5 ba80d5", "5CS-6 455fdc", "5CS-7 461a43", "5CS-8 17196d", "5CS-9 30a726", "5CS-10 05e520", "5CS-11 0493ca", "5CS-12 77e010", "5CS-13 aaae39", "5CS-14 014d56", "5CS-15 04f9f3", "5CS-16 da5eaf", "5CS-17 1ea2fb", "5CS-18 fcb723", "5CS-19 7ff9c4", "5CS-20 e5be84", "5CS-21 727b79", "5CS-22 883eb9", "5CS-23 970ecd", "5CS-24 36545f", "5CS-25 acbeec", "5CS-26 9b6f77", "5CS-27 9abff0", "5CS-28 c7f889", "5CS-29 d6801b", "5CS-30 da933f", "5CS-31 6585f5", "5CS-32 5ab801", "5CS-33 b4ab6e", "5CS-34 421bbd", "5CS-35 5b2618", "5CS-36 beaa22", "5CS-37 cacd5d", "5CS-38 963eaa", "5CS-39 68b33c", "5CS-40 caf6e0", "5CS-41 53fefc", "5CS-42 476aa6", "5CS-43 c08e8b", "5CS-44 3891c6", "5CS-45 4e598f", "5CS-46 dd810f", "5CS-47 c683d7", "5CS-48 7c92b6", "5CS-49 5099c0", "5CS-50 43060a", "5CS-51 389088", "5CS-52 28cec8", "5CS-53 fbb2f0", "5CS-54 f12636", "5CS-55 b39211", "5CS-56 7ff266", "5CS-57 764e7f", "5CS-58 85ae99", "5CS-59 52d3a2", "5CS-60 dd0c44", "5CS-61 ddcc91", "5CS-62 e0cf8c", "5CS-63 1b5ca4", "5CS-64 b1e235", "5CS-65 092dfb", "5CS-66 068eb1", "5CS-67 9b8958", "5CS-68 cafcdb", "5CS-69 b8f446", "5CS-70 b46f15", "5CS-71 7d9d14", "5CS-72 7c621d", "5CS-73 5d0cc5", "5CS-74 c4d151", "5CS-75 6de1c3", "5CS-76 e4f6c4", "5CS-77 71a3de", "5CS-78 523551", "5CS-79 ffedd7", "5CS-80 9c968d", "5CS-81 aa977b", "5CS-82 c3211c", "5CS-83 b10323", "5CS-84 b18a21", "5CS-85 b10593", "5CS-86 06a6d9", "5CS-87 9a576d", "5CS-88 aeaa70", "5CS-89 04df36", "5CS-90 e9142a", "5CS-91 7dc894", "5CS-92 c02d10", "5CS-93 c4f41b", "5CS-94 e5b4ef", "5CS-95 7f2cfb", "5CS-96 8ef884", "5CS-97 69349c","5CT-1 72b19b", "5CT-2 d9e62c", "5CT-3 837af3", "5CT-4 87272c", "5CT-5 ea92d5", "5CT-6 4fb2dc", "5CT-7 001d43", "5CT-8 6c416d", "5CT-9 459e26", "5CT-10 0ae020", "5CT-11 39ccca", "5CT-12 4d5810", "5CT-13 17cc39", "5CT-14 348e56", "5CT-15 feddf3", "5CT-16 0ce9af", "5CT-17 b937fb", "5CT-18 789623", "5CT-19 fe5bc4", "5CT-20 0aa584", "5CT-21 97ad79", "5CT-22 03fbb9", "5CT-23 4a2fcd");

    List<String> cs6=Arrays.asList("6CS-1 31f89b", "6CS-2 601c2c", "6CS-3 c5a6f3", "6CS-4 a3aa2c", "6CS-5 da68d5", "6CS-6 1038dc", "6CS-7 062643", "6CS-8 42226d", "6CS-9 6b1426", "6CS-10 115020", "6CS-11 b135ca", "6CS-12 d73010");










    @Override
    protected void onCreate(Bundle savedInstanceState) {

        boys=findViewById(R.id.boys);
        girls=findViewById(R.id.girls);
        login=findViewById(R.id.login);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref=getSharedPreferences("com.app.aungpyaephyo.ucs_patheinvoting",MODE_PRIVATE);

        if (pref.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            Toast.makeText(this,"first time",Toast.LENGTH_LONG).show();

            Toast.makeText(this,"data inserted",Toast.LENGTH_LONG).show();
            // using the following line to edit/commit prefs
            pref.edit().putBoolean("firstrun", false).apply();

        }
        else{
            Toast.makeText(this,"not first times",Toast.LENGTH_LONG).show();
        }


   //     Toast.makeText(this,db.getData(),Toast.LENGTH_LONG).show();
   //     Log.i("data",db.getData("CST_2"));
        //intializing scan object
        qrScan = new IntentIntegrator(this);

    }

    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    // textViewName.setText(obj.getString("name"));
                    // textViewAddress.setText(obj.getString("address"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();

                    switch (result.getContents().charAt(0)-48){
                        case 1:
                            if(cst1.contains(result.getContents()))
                            {
                                Intent intent = new Intent(this, VoteActivity.class);
                                startActivity(intent);
                                this.finish();
                            }
                            break;

                        case 2:
                            if(cst2.contains(result.getContents()))
                            {
                                Intent intent = new Intent(this, VoteActivity.class);
                                startActivity(intent);
                                this.finish();
                            }
                            break;case 3:
                            if(cst3.contains(result.getContents()))
                            {
                                Intent intent = new Intent(this, VoteActivity.class);
                                startActivity(intent);
                                this.finish();
                            }
                            break;case 4:
                            if(cst4.contains(result.getContents()))
                            {
                                Intent intent = new Intent(this, VoteActivity.class);
                                startActivity(intent);
                                this.finish();
                            }
                            break;case 5:
                            if(cst5.contains(result.getContents()))
                            {
                                Intent intent = new Intent(this, VoteActivity.class);
                                startActivity(intent);
                                this.finish();
                            }
                            break;case 6:
                            if(cs6.contains(result.getContents()))
                            {
                                Intent intent = new Intent(this, VoteActivity.class);
                                startActivity(intent);
                                this.finish();
                            }
                            break;

                    }

                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void btnClick(View view) {
        //initiating the qr code scan
        switch (view.getId()) {
            case R.id.login:
                qrScan.initiateScan();
                break;
                case R.id.boys: { Intent intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);
                finish();

            }
            break;
            case R.id.girls: {
                Intent intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);

            }
            break;
        }


    }
    protected void onResume() {
        super.onResume();

    }
    }

