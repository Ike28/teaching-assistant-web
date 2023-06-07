import 'package:flutter/material.dart';

import '../api_model/course.dart';
import '../component/teacher_dashboard/header.dart';
import '../component/teacher_dashboard/info_card.dart';
import '../component/teacher_dashboard/navbar_action_items.dart';
import '../component/teacher_dashboard/side_menu.dart';
import '../config/responsive.dart';
import '../config/size_config.dart';
import '../style/palette.dart';
import 'student_dashboard.dart';

class SubjectMenu extends StatelessWidget {
  SubjectMenu({super.key, required this.course});

  final GlobalKey<ScaffoldState> _drawerKey = GlobalKey();
  final Course course;

  @override
  Widget build(BuildContext context) {
    SizeConfig().init(context);
    return Scaffold(
      key: _drawerKey,
      drawer: const SizedBox(width: 100, child: SideMenu()),
      appBar: !Responsive.isDesktop(context)
          ? AppBar(
        elevation: 0,
        backgroundColor: Palette.whiteColor,
        leading: IconButton(
            onPressed: () {
              _drawerKey.currentState?.openDrawer();
            },
            icon: const Icon(Icons.menu, color: Palette.backgroundColor)),
        actions: const <NavBarActionItems>[
          NavBarActionItems(),
        ],
      )
          : const PreferredSize(
        preferredSize: Size.zero,
        child: SizedBox(),
      ),
      body: SafeArea(
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            if (Responsive.isDesktop(context))
              const Expanded(
                child: SideMenu(),
              ),
            Expanded(
                flex: 10,
                child: SafeArea(
                  child: SingleChildScrollView(
                    padding: const EdgeInsets.symmetric(vertical: 30, horizontal: 30),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Header(title: course.name),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 4,
                        ),
                        SizedBox(
                          width: SizeConfig.screenWidth,
                          child: Wrap(
                            spacing: 20,
                            runSpacing: 20,
                            alignment: WrapAlignment.spaceBetween,
                            children: <GestureDetector>[
                              GestureDetector(
                                onTap: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute<ListaLectiiPage>(
                                        builder: (BuildContext context) => const ListaLectiiPage()),
                                  );
                                },
                                child: const InfoCard(
                                  icon: 'assets/lesson.svg',
                                  label: 'Lectii',
                                  amount: '>',
                                ),
                              ),
                              GestureDetector(
                                onTap: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute<ListaTemePage>(
                                        builder: (BuildContext context) => const ListaTemePage()),
                                  );
                                },
                                child: const InfoCard(
                                  icon: 'assets/teme.svg',
                                  label: 'Teme',
                                  amount: '>',
                                ),
                              ),
                              GestureDetector(
                                onTap: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute<ListaQuizPage>(
                                        builder: (BuildContext context) => const ListaQuizPage()),
                                  );
                                },
                                child: const InfoCard(
                                  icon: 'assets/quiz.svg',
                                  label: 'Quizuri',
                                  amount: '>',
                                ),
                              ),
                              GestureDetector(
                                onTap: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute<ListaNotePage>(
                                        builder: (BuildContext context) => const ListaNotePage()),
                                  );
                                },
                                child: const InfoCard(
                                  icon: 'assets/note.svg',
                                  label: 'Note',
                                  amount: '>',
                                ),
                              ),
                            ],
                          ),
                        ),
                        const SizedBox(
                          height: 30,
                        ),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 3,
                        )
                      ],
                    ),
                  ),
                ))
          ],
        ),
      ),
    );
  }
}
