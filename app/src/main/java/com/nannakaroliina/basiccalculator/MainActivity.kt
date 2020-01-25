package com.nannakaroliina.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    // variables to store current number and result of calculation
    private var usedOperator: String = ""
    private var resultOfCalculation = 0
    private var numbers = ArrayList<Int>()
    private var operators = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberInput(view: View) {
        // view is a button (pressed one) get text and convert to Int
        val digit = (view as Button).text.toString().toInt()
        numbers.add(digit)
        // append a new string to textView
        resultTextView.append(digit.toString())
    }

    fun operatorInput(view: View) {
        val operator = (view as Button).text.toString()
        resultTextView.append(operator)
        usedOperator = operator
        operators.add(usedOperator)

    }

    fun clearInput(view: View) {
        this.resultTextView.text = ""
        resultOfCalculation = 0
        numbers.clear()
        operators.clear()
        usedOperator = ""
    }

    fun resultButton(view: View) {

        val numberCount = numbers.size
        val operatorCount = operators.size
        var currentNumber = 0
        var currentOperator = 0
        var tempResult = numbers[currentNumber]


        if (numbers != null && operators != null) {

            currentNumber++

            while (currentNumber < numberCount && currentOperator < operatorCount)  {

                usedOperator = operators[currentOperator]

                if (usedOperator == "+") {
                    tempResult += numbers[currentNumber]
                    currentNumber++
                    currentOperator++
                }
                else if (usedOperator == "-") {
                    tempResult -= (numbers[currentNumber])
                    currentNumber++
                    currentOperator++
                }
                else if (usedOperator == "*") {
                    tempResult *= numbers[currentNumber]
                    currentNumber++
                    currentOperator++
                } else if (usedOperator == "/") {
                    tempResult /= numbers[currentNumber]
                    currentNumber++
                    currentOperator++
                }
            }

            resultOfCalculation = tempResult

        }

        resultTextView.append("=$resultOfCalculation")

    }
}
