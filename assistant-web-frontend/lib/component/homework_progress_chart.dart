import 'package:fl_chart/fl_chart.dart';
import 'package:flutter/material.dart';

import '../config/responsive.dart';
import '../style/palette.dart';

class HomeworkProgressChart extends StatelessWidget {
  const HomeworkProgressChart({super.key});

  @override
  Widget build(BuildContext context) {
    return BarChart(
      BarChartData(
          borderData: FlBorderData(show: false),
          alignment: BarChartAlignment.spaceBetween,
          axisTitleData: FlAxisTitleData(leftTitle: AxisTitle(reservedSize: 20)),
          gridData: FlGridData(drawHorizontalLine: true, horizontalInterval: 30),
          titlesData: FlTitlesData(
              leftTitles: SideTitles(
                reservedSize: 30,
                getTextStyles: (double value) => const TextStyle(color: Colors.grey, fontSize: 12),
                showTitles: true,
                getTitles: (double value) {
                  if (value == 0) {
                    return '0';
                  } else if (value == 8) {
                    return '30%';
                  } else if (value == 18) {
                    return '75%';
                  } else if (value == 25) {
                    return 'Toți';
                  } else {
                    return '';
                  }
                },
              ),
              bottomTitles: SideTitles(
                showTitles: true,
                getTextStyles: (double value) => const TextStyle(color: Colors.grey, fontSize: 12),
                getTitles: (double value) {
                  if (value == 0) {
                    return 'TEMA 1';
                  } else if (value == 1) {
                    return 'TEMA 2';
                  } else if (value == 2) {
                    return 'TEMA 3';
                  } else if (value == 3) {
                    return 'TEMA 4';
                  } else if (value == 4) {
                    return 'TEMA 5';
                  } else if (value == 5) {
                    return 'TEMA 6';
                  } else {
                    return '';
                  }
                },
              )),
          barGroups: <BarChartGroupData>[
            BarChartGroupData(x: 0, barRods: <BarChartRodData>[
              BarChartRodData(
                  y: 10,
                  colors: <Color>[Colors.black],
                  borderRadius: BorderRadius.circular(0),
                  width: Responsive.isDesktop(context) ? 40 : 10,
                  backDrawRodData: BackgroundBarChartRodData(y: 25, show: true, colors: <Color>[Palette.barBg])),
            ]),
            BarChartGroupData(x: 1, barRods: <BarChartRodData>[
              BarChartRodData(
                  y: 15,
                  colors: <Color>[Colors.black],
                  borderRadius: BorderRadius.circular(0),
                  width: Responsive.isDesktop(context) ? 40 : 10,
                  backDrawRodData: BackgroundBarChartRodData(y: 25, show: true, colors: <Color>[Palette.barBg]))
            ]),
            BarChartGroupData(x: 2, barRods: <BarChartRodData>[
              BarChartRodData(
                  y: 8,
                  colors: <Color>[Colors.black],
                  borderRadius: BorderRadius.circular(0),
                  width: Responsive.isDesktop(context) ? 40 : 10,
                  backDrawRodData: BackgroundBarChartRodData(y: 25, show: true, colors: <Color>[Palette.barBg]))
            ]),
            BarChartGroupData(x: 3, barRods: <BarChartRodData>[
              BarChartRodData(
                  y: 20,
                  colors: <Color>[Colors.black],
                  borderRadius: BorderRadius.circular(0),
                  width: Responsive.isDesktop(context) ? 40 : 10,
                  backDrawRodData: BackgroundBarChartRodData(y: 25, show: true, colors: <Color>[Palette.barBg]))
            ]),
            BarChartGroupData(x: 4, barRods: <BarChartRodData>[
              BarChartRodData(
                  y: 17,
                  colors: <Color>[Colors.black],
                  borderRadius: BorderRadius.circular(0),
                  width: Responsive.isDesktop(context) ? 40 : 10,
                  backDrawRodData: BackgroundBarChartRodData(y: 25, show: true, colors: <Color>[Palette.barBg]))
            ]),
            BarChartGroupData(x: 5, barRods: <BarChartRodData>[
              BarChartRodData(
                  y: 24,
                  colors: <Color>[Colors.black],
                  borderRadius: BorderRadius.circular(0),
                  width: Responsive.isDesktop(context) ? 40 : 10,
                  backDrawRodData: BackgroundBarChartRodData(y: 25, show: true, colors: <Color>[Palette.barBg]))
            ])
          ]),
    );
  }
}
