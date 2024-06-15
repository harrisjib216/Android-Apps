package com.example.pianochord

import kotlin.math.PI
import kotlin.math.sin

// https://samplefocus.com/tag/piano-note
// https://freesound.org/search/?f=grouping_pack%3A%222489_Piano+FF%22&s=Date+added+%28newest+first%29&g=1&page=1#sound
enum class PianoKey {
    C4,
    D4,
    E4,
    F4,
    G4,
    A4,
    B4,
}
class Piano {
    companion object {
        const val SAMPLE_RATE = 44100
        const val NUM_HARMONICS = 10
    }

    private fun generatePianoSound(frequency: Double, durationSeconds: Double = 2.0): DoubleArray {
        val numSamples = (durationSeconds * SAMPLE_RATE).toInt()
        val samples = DoubleArray(numSamples)

        val fundamental = 2 * PI * frequency / SAMPLE_RATE

        for (i in 0 until numSamples) {
            var sample = 0.0
            for (harmonic in 1..NUM_HARMONICS) {
                val harmonicFrequency = frequency * harmonic
                val phase = 2 * PI * harmonicFrequency * i / SAMPLE_RATE
                sample += sin(phase) / harmonic
            }
            samples[i] = sample
        }

        return samples
    }

    fun makeKeyboard(): Map<PianoKey, DoubleArray> {
        return mapOf(
            PianoKey.C4 to generatePianoSound(261.63),
            PianoKey.D4 to generatePianoSound(293.66),
            PianoKey.E4 to generatePianoSound(329.63),
            PianoKey.F4 to generatePianoSound(349.23),
            PianoKey.G4 to generatePianoSound(392.00),
            PianoKey.A4 to generatePianoSound(440.00),
            PianoKey.B4 to generatePianoSound(493.88),
        )
    }
}