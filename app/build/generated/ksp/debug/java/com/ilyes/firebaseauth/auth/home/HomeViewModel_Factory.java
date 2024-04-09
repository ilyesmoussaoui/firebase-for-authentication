package com.ilyes.firebaseauth.auth.home;

import com.ilyes.firebaseauth.domain.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<AuthRepository> repoProvider;

  public HomeViewModel_Factory(Provider<AuthRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<AuthRepository> repoProvider) {
    return new HomeViewModel_Factory(repoProvider);
  }

  public static HomeViewModel newInstance(AuthRepository repo) {
    return new HomeViewModel(repo);
  }
}
