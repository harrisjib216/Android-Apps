package com.harrisjib216.snapchatclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class Camera : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_camera, container, false).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {

            }
        }

        return root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
}

@Composable
fun GallerySheet() {
//    BottomSheetScaffold(
//        val scaffoldState = rememberBottomSheetScaffoldState()
//        sheetContent = {
//
//        }
//    )
}