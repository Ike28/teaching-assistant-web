import 'package:flutter/material.dart';

import '../../config/responsive.dart';
import '../../config/size_config.dart';
import '../../sample_dashboard_data.dart';
import '../../style/palette.dart';
import '../../style/primary_text.dart';

class HistoryTable extends StatelessWidget {
  const HistoryTable({super.key});

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      scrollDirection: Responsive.isDesktop(context) ? Axis.vertical : Axis.horizontal,
      child: SizedBox(
        width: SizeConfig.screenWidth,
        child: Table(
          defaultVerticalAlignment: TableCellVerticalAlignment.middle,
          children: List<TableRow>.generate(
            recentHistory.length,
            (int index) => TableRow(
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(10),
              ),
              children: <Widget>[
                Container(
                  alignment: Alignment.centerLeft,
                  padding: const EdgeInsets.only(top: 10.0, bottom: 10.0, left: 20.0),
                  child: CircleAvatar(
                    radius: 17,
                    backgroundImage: NetworkImage(recentHistory[index]['avatar']!),
                  ),
                ),
                PrimaryText(
                  text: recentHistory[index]['student_name'],
                  size: 16,
                  color: Palette.secondary,
                ),
                PrimaryText(
                  text: recentHistory[index]['time'],
                  size: 16,
                  color: Palette.secondary,
                ),
                PrimaryText(
                  text: recentHistory[index]['task'],
                  size: 16,
                  color: Palette.secondary,
                ),
                PrimaryText(
                  text: recentHistory[index]['status'],
                  size: 16,
                  color: Palette.secondary,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
