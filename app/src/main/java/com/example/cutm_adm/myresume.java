package com.example.cutm_adm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import com.itextpdf.layout.Document;
import android.widget.EditText;
import android.widget.Toast;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class myresume extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16,et17,et18,et19,et20,et21;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myresume);

        et1=(EditText)findViewById(R.id.name);
        et2=(EditText)findViewById(R.id.emailid);
        et3=(EditText)findViewById(R.id.phonenumber);
        et4=(EditText)findViewById(R.id.address);
        et5=(EditText)findViewById(R.id.coursename);
        et6=(EditText)findViewById(R.id.universityname);
        et7=(EditText)findViewById(R.id.courseduration);
        et8=(EditText)findViewById(R.id.cgpa);
        et9=(EditText)findViewById(R.id.schoolname);
        et10=(EditText)findViewById(R.id.schoolboard);
        et11=(EditText)findViewById(R.id.yearofcompletion);
        et12=(EditText)findViewById(R.id.percentage);
        et13=(EditText)findViewById(R.id.addeducation);
        et14=(EditText)findViewById(R.id.addjobs);
        et15=(EditText)findViewById(R.id.addinternships);
        et16=(EditText)findViewById(R.id.addpositionofresponsibility);
        et17=(EditText)findViewById(R.id.addtrainingorcourses);
        et18=(EditText)findViewById(R.id.addacademicorpersonalproject);
        et19=(EditText)findViewById(R.id.addskills);
        et20=(EditText)findViewById(R.id.addportfolioorworksample);
        et21=(EditText)findViewById(R.id.addaccompleshmentoradditionaldetails);
        btn1=(Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=et1.getText().toString();
                String Emailid=et2.getText().toString();
                String Phonenumber=et3.getText().toString();
                String Address=et4.getText().toString();
                String Coursename=et5.getText().toString();
                String Universityname=et6.getText().toString();
                String Courseduration=et7.getText().toString();
                String Cgpa=et8.getText().toString();
                String Schoolname=et9.getText().toString();
                String Schoolboard=et10.getText().toString();
                String Yearofcompletion=et11.getText().toString();
                String Percentage=et12.getText().toString();
                String Addeducation=et13.getText().toString();
                String Addjobs=et14.getText().toString();
                String Addinternships=et15.getText().toString();
                String Addpositionofresponsibility=et16.getText().toString();
                String Addtrainingorcourses=et17.getText().toString();
                String Addacademicorpersonalproject=et18.getText().toString();
                String Addskills=et19.getText().toString();
                String Addportfolioorworksample=et20.getText().toString();
                String Additionaldetails=et21.getText().toString();

                try {
                    createPdf(name,Emailid,Phonenumber,Address,Coursename,Universityname,Courseduration,Cgpa,Schoolname,Schoolboard,Yearofcompletion,Percentage,Addeducation,Addjobs,Addinternships,Addpositionofresponsibility,Addtrainingorcourses,Addacademicorpersonalproject,Addskills,Addportfolioorworksample,Additionaldetails,name);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    private void createPdf(String name, String Emailid,String Phonenumber,String Address,String Coursename,String Universityname,String Courseduration,String Cgpa,String Schoolname,String Schoolboard,String Yearofcompletion,String Percentage,String Addeducation,String Addjobs,String Addinternships,String Addpositionofresponsibility,String Addtrainingorcourses,String Addacademicorpersonalproject,String Addskills,String Addportfolioorworksample,String Addaccompleshmentoradditionaldetails,String Age) throws FileNotFoundException {
        String pdfPath= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath, "MyResume.pdf");

        OutputStream op = new FileOutputStream(file);

        // Creating a PdfWriter

        PdfWriter pw = new PdfWriter(file);

        PdfWriter writer = new PdfWriter(file);

        // Creating a PdfDocument
        PdfDocument pdf = new PdfDocument(writer);
        // Creating a Document
        Document document = new Document(pdf);

        // Creating an Image object



        float width[] = {200f, 200f};
        Table table = new Table(width);
        table.addCell(new Cell().add(new Paragraph("Name")));
        table.addCell(new Cell().add(new Paragraph(name)));
        table.addCell(new Cell().add(new Paragraph("Emailid")));
        table.addCell(new Cell().add(new Paragraph(Emailid)));
        table.addCell(new Cell().add(new Paragraph("Phonenumber No")));
        table.addCell(new Cell().add(new Paragraph(Phonenumber)));
        table.addCell(new Cell().add(new Paragraph("Address")));
        table.addCell(new Cell().add(new Paragraph(Address)));
        table.addCell(new Cell().add(new Paragraph("Coursename")));
        table.addCell(new Cell().add(new Paragraph(Coursename)));
        table.addCell(new Cell().add(new Paragraph("Universityname")));
        table.addCell(new Cell().add(new Paragraph(Universityname)));
        table.addCell(new Cell().add(new Paragraph("Courseduration")));
        table.addCell(new Cell().add(new Paragraph(Courseduration)));
        table.addCell(new Cell().add(new Paragraph("Cgpa")));
        table.addCell(new Cell().add(new Paragraph(Cgpa)));
        table.addCell(new Cell().add(new Paragraph("Schoolname")));
        table.addCell(new Cell().add(new Paragraph(Schoolname)));
        table.addCell(new Cell().add(new Paragraph("Schoolboard")));
        table.addCell(new Cell().add(new Paragraph(Schoolboard)));
        table.addCell(new Cell().add(new Paragraph("Yearofcompletion")));
        table.addCell(new Cell().add(new Paragraph(Yearofcompletion)));
        table.addCell(new Cell().add(new Paragraph("Percentage")));
        table.addCell(new Cell().add(new Paragraph(Percentage)));
        table.addCell(new Cell().add(new Paragraph("Addeducation")));
        table.addCell(new Cell().add(new Paragraph(Addeducation)));
        table.addCell(new Cell().add(new Paragraph("Addjobs")));
        table.addCell(new Cell().add(new Paragraph(Addjobs)));
        table.addCell(new Cell().add(new Paragraph("Addinternships")));
        table.addCell(new Cell().add(new Paragraph(Addinternships)));
        table.addCell(new Cell().add(new Paragraph("Addpositionofresponsibility")));
        table.addCell(new Cell().add(new Paragraph(Addpositionofresponsibility)));

        table.addCell(new Cell().add(new Paragraph("Addtrainingorcourses")));
        table.addCell(new Cell().add(new Paragraph(Addtrainingorcourses)));
        table.addCell(new Cell().add(new Paragraph("Addacademicorpersonalproject")));
        table.addCell(new Cell().add(new Paragraph(Addacademicorpersonalproject)));
        table.addCell(new Cell().add(new Paragraph("Addskills")));
        table.addCell(new Cell().add(new Paragraph(Addskills)));
        table.addCell(new Cell().add(new Paragraph("Addportfolioorworksample")));
        table.addCell(new Cell().add(new Paragraph(Addportfolioorworksample)));
        table.addCell(new Cell().add(new Paragraph("Addaccompleshmentoradditionaldetails")));
        table.addCell(new Cell().add(new Paragraph(Addaccompleshmentoradditionaldetails)));

        ////////////////////////////////////////////////////
       

        document.add(table);
        document.close();
        Toast.makeText(this, "Resume Created Created", Toast.LENGTH_SHORT).show();

    }
}