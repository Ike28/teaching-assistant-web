import 'package:flutter/material.dart';

import '../../config/size_config.dart';
import '../../sample_dashboard_data.dart';
import '../../style/palette.dart';
import '../../style/primary_text.dart';
import 'homework_list_tile.dart';

class StudentPerformanceDetails extends StatelessWidget {
  const StudentPerformanceDetails({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(crossAxisAlignment: CrossAxisAlignment.start, children: <Widget>[
      SizedBox(
        height: SizeConfig.blockSizeVertical * 5,
      ),
      Container(
          decoration: BoxDecoration(borderRadius: BorderRadius.circular(30), boxShadow: const <BoxShadow>[
        BoxShadow(
          color: Colors.grey,
          blurRadius: 15.0,
          offset: Offset(
            10.0,
            15.0,
          ),
        )
      ])),
      SizedBox(
        height: SizeConfig.blockSizeVertical * 5,
      ),
      const Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <PrimaryText>[
          PrimaryText(text: 'Rezolvate', size: 18, fontWeight: FontWeight.w800),
          PrimaryText(
            text: '',
            size: 14,
            color: Palette.secondary,
          ),
        ],
      ),
      SizedBox(
        height: SizeConfig.blockSizeVertical * 2,
      ),
      Column(
        children: List<HomeworkListTile>.generate(
          recentActivities.length,
          (int index) => HomeworkListTile(
              icon: recentActivities[index]['icon'],
              label: recentActivities[index]['label'],
              amount: recentActivities[index]['amount']),
        ),
      ),
      SizedBox(
        height: SizeConfig.blockSizeVertical * 5,
      ),
      const Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <PrimaryText>[
          PrimaryText(text: 'De rezolvat', size: 18, fontWeight: FontWeight.w800),
          PrimaryText(
            text: '',
            size: 14,
            color: Palette.secondary,
          ),
        ],
      ),
      SizedBox(
        height: SizeConfig.blockSizeVertical * 2,
      ),
      Column(
        children: List<HomeworkListTile>.generate(
          upcomingActivities.length,
          (int index) => HomeworkListTile(
              icon: upcomingActivities[index]['icon'],
              label: upcomingActivities[index]['label'],
              amount: upcomingActivities[index]['amount']),
        ),
      ),
    ]);
  }
}
