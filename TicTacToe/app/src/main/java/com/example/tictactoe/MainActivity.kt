package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.children
import com.google.android.flexbox.FlexboxLayout

data class CellAndValue(val cell: ImageButton, var value: Char)

class MainActivity : AppCompatActivity() {
    private lateinit var cells: List<List<CellAndValue>>
    private var running = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configUI()
        setUpGame()
    }

    private fun configUI() {
        // get all cells
        cells = arrayOf(
            findViewById<FlexboxLayout>(R.id.row1),
            findViewById<FlexboxLayout>(R.id.row2),
            findViewById<FlexboxLayout>(R.id.row3),
        ).map { row ->
            row.children.toList().map { cell ->
                val self = CellAndValue(cell as ImageButton, ' ')

                self.cell.setImageResource(0)
                self.cell.isEnabled = true

                cell.setOnClickListener {
                    selectCell(self)
                }

                self
            }
        }

        // set up retry button
        findViewById<Button>(R.id.retryBtn).setOnClickListener {
            setUpGame()
        }
    }

    private fun setUpGame() {
        running = true

        // enable cell, clear image, add click handler
        cells.forEach { row ->
            row.forEach { cell ->
                cell.cell.setImageResource(0)
                cell.cell.isEnabled = true
                cell.value = ' '
            }
        }

        // reset game over screen
        findViewById<FlexboxLayout>(R.id.gameOver).visibility = View.INVISIBLE

        // reset status label
        findViewById<TextView>(R.id.resultLabel).text = ""
    }

    private fun endGame(userWon: Boolean) {
        running = false

        if (userWon) {
            findViewById<TextView>(R.id.resultLabel).text = "Congrats you won!"
        } else {
            findViewById<TextView>(R.id.resultLabel).text = "Oof you lost!"
        }

        findViewById<FlexboxLayout>(R.id.gameOver).visibility = View.VISIBLE
    }

    private fun selectCell(cell: CellAndValue) {
        // update user selection
        updateCell(cell, true)

        // select random cell or nothing
        val cpuChoice = randomCpuChoice()

        // exit if no more moves, or keep playing
        if (cpuChoice == null) {
            endGame(false)
        } else {
            updateCell(cpuChoice, false)
        }
    }

    private fun updateCell(cell: CellAndValue, userSelected: Boolean) {
        if (!running) {
            return
        }

        // disable the button
        cell.cell.isEnabled = false

        // toggle image
        if (userSelected) {
            cell.cell.setImageResource(R.drawable.x)
            cell.value = 'x'
        } else {
            cell.cell.setImageResource(R.drawable.o)
            cell.value = 'o'
        }

        // check who won
        determineWinner()
    }

    private fun randomCpuChoice(): CellAndValue? {
        return cells.flatten().filter {
            it.cell.isEnabled
        }.ifEmpty {
            null
        }?.random()
    }

    private fun determineWinner() {
        var winner = ' '

        for (i in 0..<3) {
            // rows
            if (cells[i][0].value == cells[i][1].value &&
                cells[i][1].value == cells[i][2].value &&
                cells[i][0].value != ' ') {
                winner = cells[i][0].value
                break
            }

            // Columns
            if (cells[0][i].value == cells[1][i].value &&
                cells[1][i].value == cells[2][i].value &&
                cells[0][i].value != ' ') {
                winner = cells[i][0].value
                break
            }
        }

        // left diagonal
        if (cells[0][0].value == cells[1][1].value &&
            cells[1][1].value == cells[2][2].value &&
            cells[0][0].value != ' ') {
            winner = cells[0][0].value
        }

        // right diagonal
        if (cells[0][2].value == cells[1][1].value &&
            cells[1][1].value == cells[2][0].value &&
            cells[0][2].value != ' ') {
            winner = cells[0][2].value
        }

        when (winner) {
            'x' -> endGame(true)
            'o' -> endGame(false)
            else -> return
        }
    }
}