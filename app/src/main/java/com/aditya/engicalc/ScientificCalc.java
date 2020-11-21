package com.aditya.engicalc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import org.apache.commons.math3.special.Gamma;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ScientificCalc extends Fragment {

   HorizontalScrollView scrollView1,scrollView2;
    TextView tvResult;
    EditText tvInput;
    View v;

    Button btnAc, btnC, btnOpenBracket, btnCloseBracket, btnSin, btnCos, btnTan, btnLog, btnLn, btnFact, btnSquare, btnRoot, btnDivide, btnExponent,
            btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero,
            btnDecimal, btnPi, btnEqual, btnMultiply, btnPlus, btnMinus;

    private static final String ERROR = "Error";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_scientific_calc,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         v= getView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        // initialise textViews
        super.onActivityCreated(savedInstanceState);
        tvResult = v.findViewById(R.id.txtResult);
        tvInput = v.findViewById(R.id.txtInput);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tvInput.setShowSoftInputOnFocus(false);
        }
        scrollView1= v.findViewById(R.id.horizontalScroll_1);
        scrollView2=v.findViewById(R.id.horizontalScroll_2);

        // initialise buttons
        btnAc = v.findViewById(R.id.btnAc);
        btnC = v.findViewById(R.id.btnC);
        btnOpenBracket = v.findViewById(R.id.btnOpenBracket);
        btnCloseBracket = v.findViewById(R.id.btnCloseBracket);
        btnSin = v.findViewById(R.id.btnSin);
        btnCos = v.findViewById(R.id.btnCos);
        btnTan = v.findViewById(R.id.btnTan);
        btnLog = v.findViewById(R.id.btnLog);
        btnLn = v.findViewById(R.id.btnLn);
        btnFact = v.findViewById(R.id.btnFact);
        btnSquare = v.findViewById(R.id.btnSquare);
        btnRoot = v.findViewById(R.id.btnRoot);
        btnDivide = v.findViewById(R.id.btnDivide);
        btnExponent = v.findViewById(R.id.btnExponent);
        btnOne = v.findViewById(R.id.btn1);
        btnTwo = v.findViewById(R.id.btn2);
        btnThree = v.findViewById(R.id.btn3);
        btnFour = v.findViewById(R.id.btn4);
        btnFive = v.findViewById(R.id.btn5);
        btnSix = v.findViewById(R.id.btn6);
        btnSeven = v.findViewById(R.id.btn7);
        btnEight = v.findViewById(R.id.btn8);
        btnNine = v.findViewById(R.id.btn9);
        btnZero = v.findViewById(R.id.btn0);
        btnDecimal = v.findViewById(R.id.btnDot);
        btnPi = v.findViewById(R.id.btnPi);
        btnEqual = v.findViewById(R.id.btnEqual);
        btnMultiply = v.findViewById(R.id.btnMultiply);
        btnPlus = v.findViewById(R.id.btnPlus);
        btnMinus = v.findViewById(R.id.btnMinus);


        btnSquare.setText(Html.fromHtml("x<sup><small>y</small></sup>"));
        btnSquare.setAllCaps(false);
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                tvInput.setText("");


            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cursorPosition = tvInput.getSelectionStart();
                String editText= tvInput.getText().toString();
                boolean isAtLast= true;
                String expression="";

                //Log.d("Inside Del",expression);
                if (cursorPosition==0){
                    return;
                }

                if(cursorPosition==editText.length()){
                    expression+= editText;
                }
                else {
                    expression= expression+ editText.substring(0,cursorPosition);
                    isAtLast=false;
                }

                if (expression.length() >= 4) {
                    String substring = expression.substring(expression.length() - 4);
                    final String substring1 = expression.substring(0, expression.length() - 4);
                    if (substring.equals("sin(")) {
                        if(isAtLast){
                            tvInput.setText(substring1);

                        }
                        else {
                            String sub =substring1+editText.substring(cursorPosition);
                            tvInput.setText(sub);

                        }
                        cursorPosition-=4;

                    } else if (substring.equals("cos(")) {
                        if(isAtLast){
                            tvInput.setText(substring1);

                        }
                        else {
                            String sub =substring1+editText.substring(cursorPosition);
                            tvInput.setText(sub);
                        }
                        cursorPosition-=4;

                    } else if (substring.equals("tan(")) {
                        if(isAtLast){
                            tvInput.setText(substring1);

                        }
                        else {
                            String sub =substring1+editText.substring(cursorPosition);
                            tvInput.setText(sub);

                        }
                        cursorPosition-=4;

                    } else if (substring.equals("log(")) {
                        if(isAtLast){
                            tvInput.setText(substring1);
                        }
                        else {
                            String sub =substring1+editText.substring(cursorPosition);
                            tvInput.setText(sub);

                        }
                        cursorPosition-=4;

                    } else if (expression.substring(expression.length() - 3).equals("ln(")) {
                        String replace = expression.substring(0, expression.length() - 3);
                        if(isAtLast){
                            tvInput.setText(replace);

                        }
                        else {
                            String s= replace+editText.substring(cursorPosition);
                            tvInput.setText(s);

                        }
                        cursorPosition-=3;

                    } else if (!tvInput.getText().toString().equals("")) {
                        String subString =  editText.substring(0,cursorPosition-1);
                        if(isAtLast){
                            tvInput.setText(subString);
                            cursorPosition--;
                        }
                        else {
                            String s= subString+ editText.substring(cursorPosition);
                            tvInput.setText(s);
                            cursorPosition--;
                        }

                    }


                } else if (expression.length() >= 3) {
                    if (expression.substring(expression.length() - 3).equals("ln(")) {
                        String replace = expression.substring(0, expression.length() - 3);
                        if(isAtLast){
                            tvInput.setText(replace);

                        }
                        else {
                            String s= replace+editText.substring(cursorPosition);
                            tvInput.setText(s);

                        }
                        cursorPosition-=3;
                    } else if (!tvInput.getText().toString().equals("")) {
                        String subString =  editText.substring(0,cursorPosition-1);
                        if(isAtLast){
                            tvInput.setText(subString);
                            cursorPosition--;
                        }
                        else {
                            String s= subString+ editText.substring(cursorPosition);
                            tvInput.setText(s);
                            cursorPosition--;
                        }

                    }

                } else if (!tvInput.getText().toString().equals("")) {
                    String subString =  editText.substring(0,cursorPosition-1);
                    if(isAtLast){
                        tvInput.setText(subString);
                        cursorPosition--;
                    }
                    else {
                        String s= subString+ editText.substring(cursorPosition);
                        tvInput.setText(s);
                        cursorPosition--;
                    }
                }


                if(cursorPosition>0){
                    tvInput.setSelection(cursorPosition);
                }


            }
        });

        btnOpenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("(");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) + "("+tvInput.getText().toString().substring(tvInput.getSelectionStart());
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });


        btnCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText(")");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+")" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });

                tvInput.setSelection(tvInput.getText().length());
            }
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("sin(");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())  + "sin("+tvInput.getText().toString().substring(tvInput.getSelectionStart());
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("cos(");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) +"cos("+tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("tan(");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) + "tan(" +tvInput.getText().toString().substring(tvInput.getSelectionStart());
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("log(");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) + "log("+tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("ln(");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) + "ln("+tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("");
                } else if (tvInput.getText().toString().equals("")) {
                    tvInput.setText("");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) + "!" +tvInput.getText().toString().substring(tvInput.getSelectionStart());
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());
            }
        });
        btnSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().trim().isEmpty()) {
                    tvInput.setText("");
                } else if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("^");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+ "^" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());

            }
        });
        btnRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("√(");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) + "√(" +tvInput.getText().toString().substring(tvInput.getSelectionStart());
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());

            }
        });

        btnExponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("e");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) + "e"+tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });

                tvInput.setSelection(tvInput.getText().length());
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("1");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+ "1" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);

                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());

            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("2");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+ "2" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("3");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+ "3" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("4");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+ "4" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);

                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());

            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("5");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+ "5" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);

                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());

            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("6");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())  + "6"+tvInput.getText().toString().substring(tvInput.getSelectionStart());
                    tvInput.setText(input);

                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());

            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("7");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+ "7" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());



            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("8");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+ "8" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("9");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) + "9" +tvInput.getText().toString().substring(tvInput.getSelectionStart());
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("0");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart())+ "0" +tvInput.getText().toString().substring(tvInput.getSelectionStart()) ;
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean canPutDecimal = true;
                String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) +tvInput.getText().toString().substring(tvInput.getSelectionStart());
                for (int i = input.length() - 1; i >= 0; i--) {
                    char ch = input.charAt(i);

                    if (ch == '.') {
                        canPutDecimal = false;
                        break;
                    } else if (ch == '+' || ch == '-' || ch == '×' || ch == '÷') {
                        break;
                    }
                }
                if (canPutDecimal) {
                    if (tvInput.getText().toString().equals(ERROR)) {
                        tvInput.setText(".");
                    } else {

                        String newInput = tvInput.getText().toString() + '.';
                        tvInput.setText(newInput);
                    }
                    scrollView2.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView2.fullScroll(View.FOCUS_RIGHT);
                        }
                    });

                }
                tvInput.setSelection(tvInput.getText().length());



            }
        });
        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("π");
                } else {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) +tvInput.getText().toString().substring(tvInput.getSelectionStart()) + "π";
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("×");
                } else if (tvInput.getText().toString().trim().equals("")) {
                    tvInput.setText("");
                } else if (!tvInput.getText().toString().endsWith("×")) {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) +tvInput.getText().toString().substring(tvInput.getSelectionStart()) + "×";
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("÷");
                } else if (tvInput.getText().toString().trim().equals("")) {
                    tvInput.setText("");
                } else if (!tvInput.getText().toString().endsWith("÷")) {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) +tvInput.getText().toString().substring(tvInput.getSelectionStart()) + "÷";
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("+");
                } else if (tvInput.getText().toString().trim().equals("")) {
                    tvInput.setText("");
                } else if (!tvInput.getText().toString().endsWith("+")) {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) +tvInput.getText().toString().substring(tvInput.getSelectionStart()) + "+";
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals(ERROR)) {
                    tvInput.setText("-");
                } else if (tvInput.getText().toString().isEmpty()) {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) +tvInput.getText().toString().substring(tvInput.getSelectionStart()) + "-";
                    tvInput.setText(input);

                } else if (!tvInput.getText().toString().endsWith("-")) {
                    String input = tvInput.getText().toString().substring(0,tvInput.getSelectionStart()) +tvInput.getText().toString().substring(tvInput.getSelectionStart()) + "-";
                    tvInput.setText(input);
                }
                scrollView2.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_RIGHT);
                    }
                });
                tvInput.setSelection(tvInput.getText().length());


            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                String val = tvInput.getText().toString();
                if (val.equals(ERROR)) {
                    tvInput.setText("");
                } else {
                    String replacedString = val.replace('÷', '/').replace('×', '*');
                    if (replacedString.length() != 0) {
                        tvResult.setText(val);
                        String answer = evaluate(replacedString);
                        String finalAnswer;
                        if (!answer.equals(ERROR)) {
                            finalAnswer = answer.replace('E', 'e');

                        } else {
                            finalAnswer = answer;
                        }

                        String newAnswer;
                        boolean isNewAnswer = false;
                        for (int i = 0; i < answer.length(); i++) {
                            char c = answer.charAt(i);
                            if (c == '.') {
                                if (i == answer.length() - 2 && answer.charAt(answer.length() - 1) == '0') {
                                    newAnswer = finalAnswer.substring(0, answer.length() - 2);
                                    tvInput.setText(newAnswer);
                                    isNewAnswer = true;
                                }
                                break;
                            }
                        }
                        if (!isNewAnswer) {
                            tvInput.setText(finalAnswer);
                        }



                    }
                }

                tvInput.setSelection(tvInput.getText().length());

            }
        });

    }


    public static double factorial(double d) {
        return Gamma.gamma(d + 1);
    }


    public static String evaluate(String expression) {
        int pos = 0;
        char ch = expression.charAt(0);
        Queue<String> postFix = new LinkedList<>();
        Stack<String> operator = new Stack<>();
        String ans = "";


        while (pos != expression.length()) {


            // If ch is number add to queue
            if (ch >= '0' && ch <= '9' || ch == '.') {

                NumberHelperClass numberHelperClass = isaNumber(expression, pos);
                if (numberHelperClass.isLastChar) {
                    postFix.add(numberHelperClass.num);
                    break;
                } else {
                    postFix.add(numberHelperClass.num);
                    pos = numberHelperClass.currentPos;
                    ch = expression.charAt(pos);
                }
            }

            //if ch is '!' factorial function

            else if (ch == '!') {
                if (pos == 0) {
                    return ERROR;
                } else {
                    operator.push(Character.toString('!'));

                }

                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
            }

            // if ch is '+' or '-' operator push to stack with precedence
            else if (ch == '+' || ch == '-') {
                boolean isNegativeNum = false;
                boolean isPositiveNum= false;
                boolean skipToNext = false;
                if (ch == '-') {
                    if (pos > 0) {
                        char prevChar = expression.charAt(pos - 1);
                        if (prevChar == '(' || prevChar == '+' || prevChar == '*' || prevChar == '/' || prevChar == '^') {
                            if (pos < expression.length() - 1) {
                                char nextChar = expression.charAt(pos + 1);
                                if (nextChar == 'e') {
                                    postFix.add(Double.toString(-Math.E));
                                    pos = pos + 1;
                                    ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                                    skipToNext = true;

                                } else if (nextChar == 'π') {
                                    postFix.add(Double.toString(-Math.PI));
                                    pos = pos + 1;
                                    ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                                    skipToNext = true;

                                } else {
                                    isNegativeNum = true;
                                }
                            }
                        }


                    } else if (pos == 0) {
                        if (pos < expression.length() - 1) {
                            char nextChar = expression.charAt(pos + 1);
                            if (nextChar == 'e') {
                                postFix.add(Double.toString(-Math.E));
                                pos = pos + 1;
                                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                                skipToNext = true;

                            } else if (nextChar == 'π') {
                                postFix.add(Double.toString(-Math.PI));
                                pos = pos + 1;
                                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                                skipToNext = true;
                            } else {
                                isNegativeNum = true;
                            }
                        }

                    }
                }

                else  {

                    char prevChar = expression.charAt(pos - 1);
                    if (prevChar == '(' || prevChar == '-' || prevChar == '*' || prevChar == '/' || prevChar == '^') {
                        if (pos < expression.length() - 1) {
                            char nextChar = expression.charAt(pos + 1);
                            if (nextChar == 'e') {
                                postFix.add(Double.toString(Math.E));
                                pos = pos + 1;
                                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                                skipToNext = true;

                            } else if (nextChar == 'π') {
                                postFix.add(Double.toString(Math.PI));
                                pos = pos + 1;
                                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                                skipToNext = true;

                            } else {
                                isPositiveNum = true;
                            }
                        }
                    }

                }


                if (isNegativeNum||isPositiveNum) {
                    NumberHelperClass numberHelperClass = isaNumber(expression, pos);
                    if (numberHelperClass.isLastChar) {
                        postFix.add(numberHelperClass.num);

                        break;
                    } else {
                        postFix.add(numberHelperClass.num);
                        pos = numberHelperClass.currentPos;
                        ch = expression.charAt(pos);
                    }
                } else if (operator.size() > 1 && !skipToNext) {
                    if (operator.peek().equals(Character.toString('*')) || operator.peek().equals(Character.toString('/'))) {

                        postFix.add(operator.pop());
                    }
                    operator.push(Character.toString(ch));
                    ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                } else if (!skipToNext) {
                    operator.push(Character.toString(ch));
                    ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';

                }


            }
            // if ch is '*' or '/' or '(' push to stack
            else if (ch == '*' || ch == '/' || ch == '(') {
                if (ch == '(') {
                    if (pos >= 1) {
                        char prev = expression.charAt(pos - 1);
                        if (prev >= '1' && prev <= '9') {
                            operator.push(Character.toString('*'));
                        }
                    }

                }
                if (operator.size() > 1) {
                    if (operator.peek().equals(Character.toString('^'))) {

                        postFix.add(operator.pop());
                    }
                }
                operator.push(Character.toString(ch));
                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';

            } else if (ch == '^') {
                operator.push(Character.toString(ch));
                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
            }
            // if ch is ')' pop from stack till '(' is encountered and everything to queue
            else if (ch == ')') {

                if (operator.isEmpty() || pos == 0) {

                    ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';

                } else if (pos >= 1) {
                    int prevPos = pos - 1;
                    char prevChar = expression.charAt(prevPos);
                    if (prevChar == '+' || prevChar == '-' || prevChar == '*' || prevChar == '/') {
                        ans += ERROR;
                        return ans;
                    } else {
                        while (!operator.isEmpty()) {
                            if (operator.peek().equals(Character.toString('('))) {
                                break;
                            } else {
                                postFix.add(operator.pop());
                            }

                        }
                    }
                    if (!operator.isEmpty()) {
                        if (operator.peek().equals(Character.toString('('))) {
                            operator.pop();
                        }
                    }

                    ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                }


            } else if (ch == 'e') {
                if (pos > 0) {
                    char prevChar = expression.charAt(pos - 1);

                    if (prevChar >= '0' && prevChar <= '9' || prevChar == ')' || prevChar == 'π') {
                        operator.push(Character.toString('*'));

                    }

                }
                if (pos < expression.length() - 1) {
                    char nexChar = expression.charAt(pos + 1);
                    if (nexChar >= '0' && nexChar <= '9') {
                        operator.push(Character.toString('*'));
                    }
                }
                postFix.add(Double.toString(Math.E));
                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
            } else if (ch == 'π') {
                if (pos > 0) {
                    char prevChar = expression.charAt(pos - 1);
                    if (prevChar >= '0' && prevChar <= '9' || prevChar == '.' || prevChar == 'e') {
                        operator.push(Character.toString('*'));

                    }
                }
                if (pos < expression.length() - 1) {
                    char nextChar = expression.charAt(pos + 1);
                    if (nextChar >= '0' && nextChar <= '9'||nextChar=='(') {
                        operator.push(Character.toString('*'));
                    }
                }
                postFix.add(Double.toString(Math.PI));
                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
            }

            // if its a function
            else if (ch >= 'a' && ch <= 'y' || ch == '√') {
                if (pos >= 1) {
                    if (expression.charAt(pos - 1) >= '1' && expression.charAt(pos - 1) <= '9' || expression.charAt(pos - 1) == '.') {
                        operator.push(Character.toString('*'));
                    }
                }


                StringBuilder func = new StringBuilder();
                if (ch == '√') {
                    func.append("√");
                    if(pos<expression.length()){
                        char nextChar= expression.charAt(pos+1);
                        if(nextChar=='('){
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                        }
                    }


                } else {
                    while (ch >= 'a' && ch <= 'z') {
                        func.append(ch);
                        ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';
                    }
                }


                StringBuilder funcExpression = new StringBuilder("(");
                int openBrackets = 1;
                int closeBrackets = 0;
                ch = (++pos < expression.length()) ? expression.charAt(pos) : 'z';

                if (ch == 'z') {
                    return ERROR;
                }
                while (openBrackets != closeBrackets) {
                    if (ch == ')') {
                        closeBrackets++;
                    } else if (ch == '(') {
                        openBrackets++;
                    }
                    funcExpression.append(ch);

                    pos++;
                    if (pos < expression.length()) {
                        ch = expression.charAt(pos);
                    } else {
                        break;
                    }

                }
                if (funcExpression.length() == 0) {
                    return ERROR;
                }
                String evaluated = evaluate(funcExpression.toString());
                if (evaluated.equals(ERROR)) {
                    return ERROR;
                }

                switch (func.toString()) {
                    case "sin": {
                        double answer = Math.sin(Double.parseDouble(evaluated));
                        postFix.add(Double.toString(answer));
                        break;
                    }
                    case "cos": {
                        double answer = Math.cos(Double.parseDouble(evaluated));
                        postFix.add(Double.toString(answer));
                        break;
                    }
                    case "tan": {

                        double answer = Math.tan(Double.parseDouble(evaluated));
                        postFix.add(Double.toString(answer));
                        break;
                    }
                    case "log": {

                        double answer = Math.log10(Double.parseDouble(evaluated));
                        postFix.add(Double.toString(answer));
                        break;
                    }
                    case "ln": {

                        double answer = Math.log(Double.parseDouble(evaluated));
                        postFix.add(Double.toString(answer));
                        break;
                    }
                    case "√": {
                        double answer = Math.sqrt(Double.parseDouble(evaluated));
                        postFix.add(Double.toString(answer));
                        break;

                    }
                    default:{

                    }
                }
            }


        }

        if (postFix.isEmpty()) {
            return ERROR;
        }

        while (!operator.isEmpty()) {

            postFix.add(operator.pop());
        }
        ans = Calculation(postFix);
        return ans;

    }

    public static NumberHelperClass isaNumber(String expression, int pos) {

        String number;
        int currentPos = pos;
        char ch = expression.charAt(currentPos);
        if(ch=='-'||ch=='+'){
            currentPos++;
            ch=expression.charAt(currentPos);
        }


        while (ch >= '0' && ch <= '9' || ch == '.' ) {


            if (currentPos < expression.length() - 1) {
                ++currentPos;
                ch = expression.charAt(currentPos);
            } else {

                break;
            }


        }
        if (currentPos == expression.length() - 1) {
            if (ch >= '0' && ch <= '9' || ch == '.') {
                number = expression.substring(pos);
                return new NumberHelperClass(number, currentPos, true);


            } else {
                number = expression.substring(pos, currentPos);
                return new NumberHelperClass(number, currentPos, false);
            }

        } else {
            number = expression.substring(pos, currentPos);
            return new NumberHelperClass(number, currentPos, false);

        }

    }


    public static String Calculation(Queue<String> PostFixExpression) {
        Stack<String> Calculation = new Stack<>();
        String ans = "";

        while (!PostFixExpression.isEmpty()) {
            String token = PostFixExpression.poll();
            assert token != null;
            if (token.equals(Character.toString('+')) || token.equals(Character.toString('-')) || token.equals(Character.toString('*')) || token.equals(Character.toString('/')) || token.equals(Character.toString('^'))) {

                if (Calculation.size() == 1) {
                    return ERROR;
                } else {
                    String numberRight = Calculation.pop();
                    String numberLeft = Calculation.pop();
                    if (token.equals(Character.toString('+'))) {
                        double add = Double.parseDouble(numberLeft) + Double.parseDouble(numberRight);
                        String evaluatedAns = Double.toString(add);
                        Calculation.push(evaluatedAns);
                    } else if (token.equals(Character.toString('-'))) {
                        double sub = Double.parseDouble(numberLeft) - Double.parseDouble(numberRight);
                        String evalutedAns = Double.toString(sub);
                        Calculation.push(evalutedAns);

                    } else if (token.equals(Character.toString('*'))) {
                        double mul = Double.parseDouble(numberLeft) * Double.parseDouble(numberRight);
                        String evalutedAns = Double.toString(mul);
                        Calculation.push(evalutedAns);

                    } else if (token.equals(Character.toString('/'))) {
                        if (Double.parseDouble(numberRight) == 0.0) {
                            ans = "Cannot Divide By Zero";
                            return ans;
                        } else {
                            double div = Double.parseDouble(numberLeft) / Double.parseDouble(numberRight);
                            String evalutedAns = Double.toString(div);
                            Calculation.push(evalutedAns);
                        }
                    } else if (token.equals(Character.toString('^'))) {
                        double powerIs = Math.pow(Double.parseDouble(numberLeft), Double.parseDouble(numberRight));

                        Calculation.push(Double.toString(powerIs));
                    }


                }
            } else if (token.equals(Character.toString('!'))) {
                String number = Calculation.pop();
                double factAns = factorial(Double.parseDouble(number));
                Calculation.push(Double.toString(factAns));
            }
            else if(!token.equals(Character.toString('('))){
                Calculation.push(token);
            }


        }
        if (Calculation.size() != 1) {
            return ERROR;
        }
        ans += Calculation.pop();
        return ans;

    }


}






