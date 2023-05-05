import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';

import '../../style/palette.dart';

class SocialLoginButton extends StatelessWidget {
  const SocialLoginButton({
    super.key,
    required this.iconPath,
    required this.label,
    this.horizontalPadding = 100,
  });
  final String iconPath;
  final String label;
  final double horizontalPadding;

  @override
  Widget build(BuildContext context) {
    return TextButton.icon(
      onPressed: () {},
      icon: SvgPicture.asset(
        iconPath,
        width: 25,
        color: Palette.whiteColor,
      ),
      label: Text(
        label,
        style: const TextStyle(
          color: Palette.whiteColor,
          fontSize: 17,
        ),
      ),
      style: TextButton.styleFrom(
        padding: EdgeInsets.symmetric(vertical: 30, horizontal: horizontalPadding),
        shape: RoundedRectangleBorder(
          side: const BorderSide(
            color: Palette.borderColor,
            width: 3,
          ),
          borderRadius: BorderRadius.circular(10),
        ),
      ),
    );
  }
}
