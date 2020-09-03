package com.example.navigationcomponent

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_deep_link.*

class DeepLinkFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deep_link, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val arg = arguments?.getString("myArg")
        txt_text.text = arg

        btn_push_notification.setOnClickListener {


            val args = Bundle()
            args.putString("myArg", edt_arg.text.toString())

            val pendingIntent = findNavController().createDeepLink()
                .setGraph(R.navigation.nav_graph)
                .setDestination(R.id.deepLinkFragment)
                .setArguments(args)
                .createPendingIntent()


            val notificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(
                    NotificationChannel(
                        "deepLink", "Deep Links", NotificationManager.IMPORTANCE_HIGH
                    )
                )
            }


            val builder = NotificationCompat.Builder(
                requireContext(), "deepLink"
            )
                .setContentTitle("Navigation")
                .setContentText("Deep link to Navigation Component")
                .setSmallIcon(R.drawable.ic_baseline_add_alert_24)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)

            notificationManager.notify(0, builder.build())


        }
    }
}