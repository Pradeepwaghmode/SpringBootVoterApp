package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.service.CandidateHelperImpl;
import com.nt.module.CandidateVotingDetails;
import com.nt.module.Users_info;
import com.nt.module.VoterReport;
import com.nt.repository.ICandidateVotingDetailsRepository;
import com.nt.repository.IReportRepository;
import com.nt.repository.IUserRepository;

@Component
public class VoterServiceImpl implements IVoterService {

	@Autowired
	private IUserRepository repo;

	@Autowired
	private ICandidateVotingDetailsRepository repo1;

	@Autowired
	private IReportRepository rerepo;

	private Users_info current_user;

	@Autowired
	private CandidateHelperImpl canInfo;

	List<CandidateVotingDetails> list;

	@Override
	public String saveUser(Users_info user) {
		// TODO Auto-generated method stub
		user.setFlag("notdone");
		Integer uid = repo.save(user).getUserid();
		return "user is saved with :: " + uid;
	}

	@Override
	public String UserValidation(Users_info user) {
		// TODO Auto-generated method stub
		System.out.println("VoterServiceImpl.UserValidation()");

		System.out.println("Current User is :: " + current_user);
		Users_info u = repo.finuserByUserName(user.getUsername());
		if (!(u == null) || !(Objects.isNull(u))) {
			if (u.getUsername().equalsIgnoreCase(user.getUsername())
					&& u.getPassword().equalsIgnoreCase(user.getPassword()) && u.getRole().equalsIgnoreCase("Admin")) {
				System.out.println("admin");
				current_user = u;

				return "admin";
			}

			if (u.getUsername().equalsIgnoreCase(user.getUsername())
					&& u.getPassword().equalsIgnoreCase(user.getPassword()) && u.getRole().equalsIgnoreCase("Voter")) {
				System.out.println("YES");
				current_user = u;

				return "yes";
			}
		}
		System.out.println("NO");
		return " no";
	}

	@Override
	public String candidateVoting(CandidateHelperImpl cand) {
		// TODO Auto-generated method stub
		System.out.println(cand);
		VoterReport report = new VoterReport();

		System.out.println("VoterServiceImpl.candidateVoting()");

		if (current_user.getFlag().equalsIgnoreCase("notdone")) {

			int flg = 0;
			int indicator = 0;
			list = repo1.findAll();
			List<Integer> can = new ArrayList();
			can.add(0, cand.getC1());
			can.add(1, cand.getC2());
			can.add(2, cand.getC3());
			can.add(3, cand.getC4());
			System.out.println("list::" + can);

			for (int no : can) {
				indicator = indicator + 1;
				if (!(no == 0)) {
					switch (indicator) {
					case 1: {
						int cnt = list.get(0).getVoteConunt() + 1;
						list.get(0).setVoteConunt(cnt);
						repo1.save(list.get(0));
						flg = 0;
						break;
					}

					case 2: {
						int cnt = list.get(1).getVoteConunt() + 1;
						list.get(1).setVoteConunt(cnt);
						repo1.save(list.get(1));
						flg = 1;
						break;
					}

					case 3: {
						int cnt = list.get(2).getVoteConunt() + 1;
						list.get(2).setVoteConunt(cnt);
						repo1.save(list.get(2));
						flg = 2;
						break;

					}

					case 4: {
						int cnt = list.get(3).getVoteConunt() + 1;
						list.get(3).setVoteConunt(cnt);
						repo1.save(list.get(3));
						flg = 3;
						break;
					}

					}

				}
			}

			current_user.setFlag("done");
			repo.save(current_user);
			report.setCname(list.get(flg).getCname());
			report.setUsname(current_user.getUsername());
			report.setCid(list.get(flg).getCid());
			report.setUserid(current_user.getUserid());
			rerepo.save(report);

			return "You are voted for " + list.get(flg).getCname() + ", Thank you !";
		}

		return "You already voted";
	}

	@Override
	public List<VoterReport> getAllreport() {

		return rerepo.findAll();
	}

	@Override
	public Users_info CurrentUser() {
		// TODO Auto-generated method stub
		return current_user;
	}

	@Override
	public CandidateHelperImpl candiateInfo() {
		// TODO Auto-generated method stub
		list = repo1.findAll();
		canInfo.setC1(list.get(0).getVoteConunt());
		canInfo.setC2(list.get(1).getVoteConunt());
		canInfo.setC3(list.get(2).getVoteConunt());
		canInfo.setC4(list.get(3).getVoteConunt());
		return canInfo;
	}
}
