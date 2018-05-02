package com.example.jacob.sleepapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AssessmentController extends AppCompatActivity implements DatabaseController.AsyncResponse {

    private String student_id = StudentModel.student_id;
    private String resultSet;
    private String type = "assessment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("HERE");
    }

    public AssessmentController () {
        DatabaseController dbController = new DatabaseController(AssessmentController.this,this);
        dbController.execute(type,this.student_id);
    }

    public String getResultSet() {
        return resultSet;
    }

    public void setResultSet(String resultSet) {
        this.resultSet = resultSet;
    }

    @Override
    public void processFinish(String output){
        setResultSet(output);
        System.out.println(output);
    }
}
