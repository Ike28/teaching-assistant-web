import 'package:flutter/material.dart';

import 'palette.dart';

class PrimaryText extends StatelessWidget {
  const PrimaryText({
    super.key,
    required this.text,
    this.fontWeight = FontWeight.w400,
    this.color = Palette.backgroundColor,
    this.size = 20,
    this.height = 1.3,
  });
  final double? size;
  final FontWeight? fontWeight;
  final Color? color;
  final String? text;
  final double? height;

  @override
  Widget build(BuildContext context) {
    return Text(
      text!,
      style: TextStyle(
        color: color,
        height: height,
        fontFamily: 'Poppins',
        fontSize: size,
        fontWeight: fontWeight,
      ),
    );
  }
}
