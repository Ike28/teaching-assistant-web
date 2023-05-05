import 'package:flutter/material.dart';

import '../config/size_config.dart';
import '../data.dart';
import '../pallete.dart';
import '../style/colors.dart';
import '../style/style.dart';
import 'paymentListTile.dart';

class PaymentDetailList extends StatelessWidget {
  const PaymentDetailList({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
      SizedBox(
        height: SizeConfig.blockSizeVertical * 5,
      ),
      Container(
        decoration:
            BoxDecoration(borderRadius: BorderRadius.circular(30), boxShadow: const [
          BoxShadow(
            color: Colors.grey,
            blurRadius: 15.0,
            offset: Offset(
              10.0,
              15.0,
            ),
          )
        ])
      ),
      SizedBox(
        height: SizeConfig.blockSizeVertical * 5,
      ),
      Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: const [
          PrimaryText(
              text: 'Rezolvate', size: 18, fontWeight: FontWeight.w800),
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
        children: List<PaymentListTile>.generate(
          recentActivities.length,
          (int index) => PaymentListTile(
              icon: recentActivities[index]["icon"],
              label: recentActivities[index]["label"],
              amount: recentActivities[index]["amount"]),
        ),
      ),
      SizedBox(
        height: SizeConfig.blockSizeVertical * 5,
      ),
      Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: const <PrimaryText>[
          PrimaryText(
              text: 'De rezolvat', size: 18, fontWeight: FontWeight.w800),
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
        children: List<PaymentListTile>.generate(
          upcomingPayments.length,
          (int index) => PaymentListTile(
              icon: upcomingPayments[index]['icon'],
              label: upcomingPayments[index]['label'],
              amount: upcomingPayments[index]['amount']),
        ),
      ),
    ]);
  }
}
