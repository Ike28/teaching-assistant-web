import 'package:flutter/material.dart';

import '../../config/responsive.dart';
import '../../style/palette.dart';
import '../../style/primary_text.dart';

class Header extends StatelessWidget {
  const Header({super.key});

  @override
  Widget build(BuildContext context) {
    return Row(mainAxisSize: MainAxisSize.min, children: <Widget>[
      const SizedBox(
        child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: <PrimaryText>[
          PrimaryText(text: 'Clasa IX B', size: 30, fontWeight: FontWeight.w800),
          PrimaryText(
            text: '',
            size: 16,
            color: Palette.secondary,
          )
        ]),
      ),
      const Spacer(),
      Expanded(
        flex: Responsive.isDesktop(context) ? 1 : 3,
        child: TextField(
          decoration: InputDecoration(
              filled: true,
              fillColor: Palette.whiteColor,
              contentPadding: const EdgeInsets.only(left: 40.0, right: 5),
              enabledBorder: OutlineInputBorder(
                borderRadius: BorderRadius.circular(30),
                borderSide: const BorderSide(color: Palette.whiteColor),
              ),
              focusedBorder: OutlineInputBorder(
                borderRadius: BorderRadius.circular(30),
                borderSide: const BorderSide(color: Palette.whiteColor),
              ),
              prefixIcon: const Icon(Icons.search, color: Palette.backgroundColor),
              hintText: 'Caută elevi',
              hintStyle: const TextStyle(color: Palette.secondary, fontSize: 14)),
        ),
      ),
    ]);
  }
}
