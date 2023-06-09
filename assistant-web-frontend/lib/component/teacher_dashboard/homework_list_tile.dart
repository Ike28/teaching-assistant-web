import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';

import '../../style/palette.dart';
import '../../style/primary_text.dart';

class HomeworkListTile extends StatelessWidget {
  const HomeworkListTile({super.key, required this.icon, required this.label, required this.amount});
  final String? icon;
  final String? label;
  final String? amount;

  @override
  Widget build(BuildContext context) {
    return ListTile(
      contentPadding: const EdgeInsets.only(right: 20),
      visualDensity: VisualDensity.standard,
      leading: Container(
          width: 50,
          padding: const EdgeInsets.symmetric(vertical: 15, horizontal: 10),
          decoration: BoxDecoration(
            color: Palette.whiteColor,
            borderRadius: BorderRadius.circular(20),
          ),
          child: SvgPicture.asset(
            icon!,
            width: 20,
          )),
      title: PrimaryText(text: label, size: 14, fontWeight: FontWeight.w500),
      subtitle: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <PrimaryText>[
          const PrimaryText(
            text: 'Primită',
            size: 12,
            color: Palette.secondary,
          ),
          PrimaryText(text: amount, size: 16, fontWeight: FontWeight.w600),
        ],
      ),
      onTap: () {},
      selected: true,
    );
  }
}
