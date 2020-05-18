package com.mamad.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var selectedOperator: String = ""
    var OldNumber: String = ""
    var NewOperation: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun clickButtonEvent(view: View){
        if (NewOperation){
            txtNumber.setText("0")
        }
        NewOperation = false

        val SelectedButton = view as Button
        var number:String = txtNumber.text.toString()
        number = Calculate(number,SelectedButton)
        txtNumber.setText(number)
    }

    fun Calculate(currentNum:String, selectedBtn: Button):String
    {
        var NewNumber:String = currentNum

        when(selectedBtn.id){
            btn_Zero.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "0"
                }
                else{
                    NewNumber += "0"
                }
            }
            btn_1.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "1"
                }
                else{
                    NewNumber += "1"
                }
            }
            btn_2.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "2"
                }
                else{
                    NewNumber += "2"
                }
            }
            btn_3.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "3"
                }
                else{
                    NewNumber += "3"
                }
            }
            btn_4.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "4"
                }
                else{
                    NewNumber += "4"
                }
            }
            btn_5.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "5"
                }
                else{
                    NewNumber += "5"
                }
            }
            btn_6.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "6"
                }
                else{
                    NewNumber += "6"
                }
            }
            btn_7.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "7"
                }
                else{
                    NewNumber += "7"
                }
            }
            btn_8.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "8"
                }
                else{
                    NewNumber += "8"
                }
            }
            btn_9.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "9"
                }
                else{
                    NewNumber += "9"
                }
            }
            btn_dot.id->{
                if (NewNumber == "0" || NewNumber == "")
                {   NewNumber = "0."

                }
                else{
                    var i = NewNumber.indexOf('.')
                    if(i == -1)
                    NewNumber += "."
                }
            }
            btn_sign.id->{
                if (NewNumber == "0" || NewNumber == "")
                {
                    NewNumber = "0"
                }
                else{
                    if (NewNumber.first() == '-')
                    {
                        NewNumber=NewNumber.substring(1,NewNumber.lastIndex+1)
                    }
                    else{
                        NewNumber = "-$NewNumber"
                    }
                }
            }

        }

        return NewNumber
    }

    fun OperateEvent(view: View){
        view as Button
        OldNumber = txtNumber.text.toString()
        when(view.id)
        {
            btn_Divide.id->{
                selectedOperator = "/"
            }
            btn_multiple.id->{
                selectedOperator = "*"
            }
            btn_Plus.id->{
                selectedOperator = "+"
            }
            btn_Minus.id->{
                selectedOperator = "-"
            }

        }
        Clear()
    }

    fun EqualEvent(view:View){
        if (OldNumber != "" && selectedOperator != "")
        {
            var answer: Double? = null
            val newNumber:Double = txtNumber.text.toString().toDouble()
            when(selectedOperator){
                "/"->{
                    answer = OldNumber.toDouble()/newNumber
                }
                "*"->{
                    answer = OldNumber.toDouble()*newNumber
                }
                "+"->{
                    answer = OldNumber.toDouble()+newNumber
                }
                "-"->{
                    answer = OldNumber.toDouble()-newNumber
                }
            }
            txtNumber.setText(answer.toString())
            NewOperation = true
        }
    }

    fun PercentEvent(view: View)
    {
        var theNumber:Double = txtNumber.text.toString().toDouble()
        txtNumber.setText((theNumber/100).toString())
    }

    fun ClearText(view: View){
        NewOperation = true
        txtNumber.setText("0")

        OldNumber = ""
        selectedOperator = ""
    }

    fun Clear(){
        txtNumber.setText("0")
    }
}