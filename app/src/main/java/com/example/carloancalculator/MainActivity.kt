package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnCalculate.setOnClickListener(){
            calLoad()
        }

        BtnReset.setOnClickListener() {
            calReset()
        }
    }

    private fun calLoad() {
        val carPrice:Double = EnterCarPrice.text.toString().toDouble()
        val downPayment:Double = EnterDownPayment.text.toString().toDouble()
        val loanPeriod:Double = EnterLoanPeriod.text.toString().toDouble()
        val interestRate:Double = EnterInterestRate.text.toString().toDouble()

        val ansCarLoan:Double = carPrice - downPayment
        val ansInterest:Double = ansCarLoan * (interestRate / 100) * loanPeriod
        val ansMthRepayment:Double = (ansCarLoan + ansInterest) / loanPeriod / 12

        textAnsCarLoan.text = "RM %.2f".format(ansCarLoan)
        textAnsInterest.text = "RM %.2f".format(ansInterest)
        textAnsMonthly.text = "RM %.2f".format(ansMthRepayment)

        
    }

    private fun calReset() {
        EnterCarPrice.text = null
        EnterDownPayment.text = null
        EnterLoanPeriod.text = null
        EnterInterestRate.text = null

        textAnsCarLoan.text = null
        textAnsInterest.text = null
        textAnsMonthly.text = null

        EnterCarPrice.requestFocus()
    }
}
