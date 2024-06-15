package com.example.a2048_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import kotlin.math.max

class MainActivity : AppCompatActivity() {
    private lateinit var screen: RelativeLayout
    private lateinit var board: Board
    private var running: Boolean = false
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpGestures()
        startGame()
    }

    /*
        makes a new board and begins the loop
        exits when game loop ends
        time: n
        space: 1
     */
    private fun startGame() {
        makeNewGame()
//        gameLoop()
    }

    /*

     */
//    private fun gameLoop() {
//        while (running) {
//            detectMovement()
//            insertRandomBlock()
//        }
//    }

    /*
        returns a 4x4 grid initialized with 0s
        and one 2 block at some random index
        also initializes game state
        time: n
        space: 1
    */
    private fun makeNewGame() {
        running = true
        score = 0

        board =Array(4) {
            IntArray(4)
        }

        insertRandomBlock()
    }

    /*
        inserts a 2 in some random position
        time: n
        space: 1
    */
    private fun insertRandomBlock() {
        var r = 0
        var c = 0

        do {
            r = (0..3).random()
            c = (0..3).random()
        } while (board[r][c] != 0)

        board[r][c] = 2
    }

    // gesuture detection
    private fun setUpGestures() {
        screen = findViewById(R.id.screen)
        screen.setOnTouchListener(object : OnSwipeTouchListener(this@MainActivity) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
            }

            override fun onSwipeRight() {
                super.onSwipeRight()

                for (r in 0..3) {
                    if (board[r][0] == board[r][1]) {
                        board[r][0] *= 2
                        board[r][1] = 0
                    } else {
                        if (board[r][0] == 0) {
                            board[r][1] = board[r][0]
                            board[r][0] = 0
                        } else if (board[r][1] == 0) {
                            board[r][0] = board[r][1]
                            board[r][1] = 0
                        } else {
                            // skip
                        }
                    }

                    // right
                    for (c in 3 downTo 1) {
                        if (board[r][c] == 0) {
                            board[r][c] = board[r][c-1]
                            board[r][c-1] = 0
                        }
                    }

                    // left
                    for (c in 0..2) {
                        if (board[r][c] == 0) {
                            board[r][c] = board[r][c+1]
                            board[r][c+1] = 0
                        }
                    }
                }
            }

            override fun onSwipeUp() {
                super.onSwipeUp()
            }

            override fun onSwipeDown() {
                super.onSwipeDown()
            }
        })
    }
}