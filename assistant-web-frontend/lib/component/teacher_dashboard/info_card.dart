import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';

import '../../config/responsive.dart';
import '../../config/size_config.dart';
import '../../style/palette.dart';
import '../../style/primary_text.dart';

class InfoCard extends StatelessWidget {
  const InfoCard({super.key, required this.icon, required this.label, required this.amount});
  final String icon;
  final String label;
  final String amount;

  @override
  Widget build(BuildContext context) {
    return Container(
      constraints: BoxConstraints(minWidth: Responsive.isDesktop(context) ? 200 : SizeConfig.screenWidth / 2 - 40),
      padding: EdgeInsets.only(top: 20, bottom: 20, left: 20, right: Responsive.isMobile(context) ? 20 : 40),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(20),
        color: Palette.whiteColor,
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          SvgPicture.asset(icon, width: 35),
          SizedBox(
            height: SizeConfig.blockSizeVertical * 2,
          ),
          PrimaryText(text: label, color: Palette.secondary, size: 16),
          SizedBox(
            height: SizeConfig.blockSizeVertical * 2,
          ),
          PrimaryText(
            text: amount,
            size: 18,
            fontWeight: FontWeight.w700,
          )
        ],
      ),
    );
  }
}
