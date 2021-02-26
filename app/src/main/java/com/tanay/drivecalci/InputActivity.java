package com.tanay.drivecalci;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        TextView TitleView= (TextView) findViewById(R.id.viewTitle);
        TextView header= (TextView) findViewById(R.id.header);
        TextView motorRatedPowerDisplay= (TextView) findViewById(R.id.motorRatedPowerDisplay);
        TextView motorWeightDisplay= (TextView) findViewById(R.id.motorWeightDisplay);
        TextView motorSizeDisplay= (TextView) findViewById(R.id.motorSizeDisplay);
        TextView maxVelocityDisplay= (TextView) findViewById(R.id.maxVelocityDisplay);
        TextView maxAccelerationDisplay= (TextView) findViewById(R.id.maxAccelerationDisplay);
        TextView averageVelocityDisplay= (TextView) findViewById(R.id.averageVelocityDisplay);
        TextView averageAccelerationDisplay= (TextView) findViewById(R.id.averageAccelerationDisplay);


        EditText weight= (EditText) findViewById(R.id.vehicleWeight);
        EditText wheelRadius= (EditText) findViewById(R.id.wheelradius);
        EditText cellVoltage= (EditText) findViewById(R.id.cellVoltage);
        EditText cellCapacity= (EditText) findViewById(R.id.cellCapacity);
        EditText cd= (EditText) findViewById(R.id.dragCefficient);
        EditText frontalArea= (EditText) findViewById(R.id.frontalArea);
        EditText rolling= (EditText) findViewById(R.id.rollingResistanceCoefficient);
        EditText inclination= (EditText) findViewById(R.id.inclination);
        EditText time= (EditText) findViewById(R.id.time_edit);
        EditText velocity=(EditText) findViewById(R.id.velocity_edit);
        EditText motorrating = (EditText) findViewById(R.id.motorRating);
        EditText motorweight = (EditText) findViewById(R.id.motorWeight);
        EditText motorsize = (EditText) findViewById(R.id.motorSize);
        EditText motorVoltage= (EditText) findViewById(R.id.motorVoltage) ;


        Button submit= (Button) findViewById(R.id.submit_button);
        Button add_velocity= (Button) findViewById(R.id.add_velocity_button);
        Button submit_velocity= (Button) findViewById(R.id.submit_velocity_button);
        Button add_motorData= (Button) findViewById(R.id.add_motorData_button);
        Button submit_motorData= (Button) findViewById(R.id.submit_motorData_button);

        LinearLayout vehicleDataView= (LinearLayout) findViewById(R.id.vehicledata);
        LinearLayout velocityTimeView= (LinearLayout) findViewById(R.id.velocitytimelayout);
        LinearLayout submitVehicle= (LinearLayout) findViewById(R.id.submit_vehicleData);
        LinearLayout submitVelocityTime= (LinearLayout) findViewById(R.id.submit_velocityTime);
        LinearLayout velocityshow= (LinearLayout) findViewById(R.id.velocityshow);
        LinearLayout motorDataView= (LinearLayout) findViewById(R.id.motorDatalayout);
        LinearLayout submitmotorDataView= (LinearLayout) findViewById(R.id.submit_MotorData);
        LinearLayout motorDataOutput= (LinearLayout) findViewById(R.id.motorDataOutput);
        LinearLayout generalDataOutput = (LinearLayout) findViewById(R.id.generalDataOutput);
        LinearLayout graphOutput= (LinearLayout) findViewById(R.id.graphOutput);
        TextView velociti= (TextView) findViewById(R.id.velociti);
        GraphView graph= (GraphView) findViewById(R.id.graphView);



        ArrayList<velocity_time_class> velocityData = new ArrayList<>();
        ArrayList<motor_size> motorRatingA = new ArrayList<>();
        LineGraphSeries<DataPoint> series= new LineGraphSeries<>();

        Calculator vehicledata= new Calculator();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightString= weight.getText().toString();
                String radiusString= wheelRadius.getText().toString();
                String voltageString= cellVoltage.getText().toString();
                String cellCapacityString= cellCapacity.getText().toString();
                String cdString= cd.getText().toString();
                String areaString= frontalArea.getText().toString();
                String rollingString= rolling.getText().toString();
                String inclinationString= inclination.getText().toString();
                if(weightString.isEmpty() || radiusString.isEmpty() || voltageString.isEmpty() || cellCapacityString.isEmpty() || cdString.isEmpty() || areaString.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter all required data",Toast.LENGTH_SHORT).show();
                }else {
                    double w= Double.parseDouble(weightString);
                    double r= Double.parseDouble(radiusString);
                    double voltage= Double.parseDouble(voltageString);
                    double capacity= Double.parseDouble(cellCapacityString);
                    double cd= Double.parseDouble(cdString);
                    double A= Double.parseDouble(areaString);
                    double rr;
                    double inclin;
                    if(rollingString.isEmpty()){
                        rr= 0.015;
                    }else {
                        rr= Double.parseDouble(radiusString);
                    }

                    if(inclinationString.isEmpty()){
                        inclin= 7.00;
                    }else {
                        inclin= Double.parseDouble(inclinationString);
                    }


                    vehicledata.setVehicleData(w,r,voltage,capacity,cd,A,rr,inclin);

                    Toast.makeText(getApplicationContext(),"Vehicle Data Saving Success",Toast.LENGTH_SHORT).show();

                    TitleView.setText("Velocity~Time Data");
                    vehicleDataView.setVisibility(View.GONE);
                    submitVehicle.setVisibility(View.GONE);
                    velocityTimeView.setVisibility(View.VISIBLE);
                    submitVelocityTime.setVisibility(View.VISIBLE);
                    velocityshow.setVisibility(View.VISIBLE);




                }


            }
        });


        add_velocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeString= time.getText().toString();
                String velocityString= velocity.getText().toString();
                if(timeString.isEmpty() || velocityString.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter all required data",Toast.LENGTH_SHORT).show();
                }else{


                    velocityData.add(new velocity_time_class(timeString,velocityString));

                    velociti.setText("Time= " + timeString + "\nVelocity= " +velocityString +"\nHas been added successfully" );
                    time.setText("");
                    velocity.setText("");
                }



            }
        });

        submit_velocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Velocity~Time Data Saving Success",Toast.LENGTH_SHORT).show();

                TitleView.setText("Motor Data");
                velocityTimeView.setVisibility(View.GONE);
                submitVelocityTime.setVisibility(View.GONE);
                motorDataView.setVisibility(View.VISIBLE);
                submitmotorDataView.setVisibility(View.VISIBLE);



            }
        });


        add_motorData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String moto= motorrating.getText().toString();
                String size= motorsize.getText().toString();
                String weight= motorweight.getText().toString();
                String motor_voltage= motorVoltage.getText().toString();

                if(moto.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter all required data",Toast.LENGTH_SHORT).show();
                }else{
                    double rating= Double.parseDouble(moto);

                    motorRatingA.add(new motor_size(moto, size, weight, motor_voltage));

                    velociti.setText("Motor Rated = " + moto +"\nSize= "+ size+"\nVoltage = "+ motor_voltage+"\nWeight= " +weight+ "\nHas been added successfully" );
                    motorrating.setText("");
                }

            }
        });


        submit_motorData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Motor Data Saving Success",Toast.LENGTH_SHORT).show();

                //Calculations
                double velocity_average=0, max_velocity=0, accel_avg=0, max_accel=0, min_time=10000, max_time=0;

                for(int i=0; i<velocityData.size(); i++){
                    velocity_time_class current= velocityData.get(i);
                    double velocit= Double.parseDouble(current.getVelocity());
                    double tim= Double.parseDouble(current.getTime());

                    if(min_time>tim){
                        min_time=tim;
                    }if(max_time<tim){
                        max_time=tim;
                    }
                    velocity_average += velocit;

                    if(velocit>max_velocity){
                        max_velocity= velocit;
                    }

                    if(i>0){
                        velocity_time_class curre= velocityData.get(i-1);
                        double veloc= Double.parseDouble(curre.getVelocity());
                        double tm= Double.parseDouble(curre.getTime());
                        double acc= (velocit- veloc)/(tm - tim);
                        accel_avg += acc;
                        if(acc>max_accel){
                            max_accel= acc;
                        }
                    }



                }
                velocity_average= velocity_average/(max_time- min_time);
                accel_avg= accel_avg/(max_time- min_time);

                double Frr= (vehicledata.getRr())*(vehicledata.getW())*(9.81)*(Math.cos(vehicledata.getInclination()));
                double Fgrade= (vehicledata.getW())*(9.81)*Math.sin(vehicledata.getInclination());
                double Faero= (0.5)*(1.225)*(vehicledata.getCd())*(vehicledata.getA())*(Math.pow((max_velocity), 2));
                double Fa= (vehicledata.getW())*(accel_avg);
                double Fa_max= (vehicledata.getW())*(max_accel);
                double Ftotal = Frr + Fgrade + Faero + Fa;
                double Ftotal_max = Frr + Fgrade + Faero + Fa_max;

                double Omega_max = max_velocity/ (vehicledata.getR());
                double N_max= (60)*Omega_max/ (2*3.141);
                double Omega_avg= velocity_average / (vehicledata.getR());
                double N_avg= (60)*Omega_avg/ (2*3.141);
                double Nmotor_max= (9.1)*N_max;
                double Nmotor_avg= (9.1)* N_avg;

                double Tmotor_max= ((9.1)* Nmotor_max*(vehicledata.getR()))/(0.85);
                double Tmotor_avg= ((9.1)* Nmotor_avg*(vehicledata.getR()))/(0.85);
                double Motor_peak_power= (2* (3.141))*Tmotor_max*Nmotor_max/60;
                double Motor_avg_power= (2* (3.141))*Tmotor_avg*Nmotor_avg/60;


                double min_diff= 1000000;
                int index=0;
                boolean exist= false;

                for(int i=0; i<motorRatingA.size(); i++){
                    double temp = Double.parseDouble(motorRatingA.get(i).getRating());

                    if((temp- Motor_peak_power)<min_diff && (temp- Motor_peak_power)>0){
                        min_diff= temp- Motor_peak_power;
                        index= i;
                    }
                }

                motorDataView.setVisibility(View.GONE);
                submitmotorDataView.setVisibility(View.GONE);
                velocityshow.setVisibility(View.GONE);
                motorDataOutput.setVisibility(View.VISIBLE);
                generalDataOutput.setVisibility(View.VISIBLE);
                graphOutput.setVisibility(View.VISIBLE);
                TitleView.setText("Motor Data Output");

                motorRatedPowerDisplay.setText("Rated Power Of Motor = "+motorRatingA.get(index).getRating());
                motorSizeDisplay.setText("Size of Motor Required = "+motorRatingA.get(index).getSize());
                motorWeightDisplay.setText("Weight of the Required Motor = "+motorRatingA.get(index).getWeight());

                maxVelocityDisplay.setText("Maximum Velocity = "+String.valueOf(max_velocity));
                maxAccelerationDisplay.setText("Maximum Acceleration = "+String.valueOf(max_accel));
                averageVelocityDisplay.setText("Average Velocity = "+String.valueOf(velocity_average));
                averageAccelerationDisplay.setText("Average Acceleration = "+String.valueOf(accel_avg));

                double x, y;
                for(int i=0; i<velocityData.size(); i++){
                    velocity_time_class current= velocityData.get(i);
                    x= Double.parseDouble(current.getTime());
                    y= Double.parseDouble(current.getVelocity());

                    series.appendData(new DataPoint(x,y), true, 100);
                }

                graph.addSeries(series);






            }
        });



    }
}